package com.sonnx.blog.controller.admin;

import com.sonnx.blog.dto.LogActions;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.controller.BaseController;
import com.sonnx.blog.dto.LogActions;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.modal.bo.RestResponseBo;
import com.sonnx.blog.modal.bo.StatisticsBo;
import com.sonnx.blog.modal.entity.ArticleDO;
import com.sonnx.blog.modal.entity.CommentDO;
import com.sonnx.blog.modal.entity.LogDO;
import com.sonnx.blog.modal.entity.UserDO;
import com.sonnx.blog.service.LogService;
import com.sonnx.blog.service.SiteService;
import com.sonnx.blog.service.UserService;
import com.sonnx.blog.utils.GsonUtils;
import com.sonnx.blog.utils.TaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 后台管理首页
 *
 * @author Administrator
 * @date 2017/3/9 009
 */
@Controller("adminIndexController")
@RequestMapping("/admin")
@Transactional(rollbackFor = TipException.class)
public class IndexController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private SiteService siteService;

    @Resource
    private LogService logService;

    @Resource
    private UserService userService;

    /**
     * 页面跳转
     *
     * @return
     */
    @GetMapping(value = {"", "/index"})
    public String index(HttpServletRequest request) {
        LOGGER.info("Enter admin index method");
        List<CommentDO> comments = siteService.recentComments(5);
        List<ArticleDO> contents = siteService.recentContents(5);
        StatisticsBo statistics = siteService.getStatistics();
        // 取最新的20条日志
        List<LogDO> logs = logService.getLogs(1, 5);

        request.setAttribute("comments", comments);
        request.setAttribute("articles", contents);
        request.setAttribute("statistics", statistics);
        request.setAttribute("logs", logs);
        LOGGER.info("Exit admin index method");
        return "admin/index";
    }

    /**
     * 个人设置页面
     */
    @GetMapping(value = "profile")
    public String profile() {
        return "admin/profile";
    }


    /**
     * 保存个人信息
     */
    @PostMapping(value = "/profile")
    @ResponseBody
    public RestResponseBo saveProfile(@RequestParam String screenName, @RequestParam String email, HttpServletRequest
            request, HttpSession session) {
        UserDO users = this.user(request);
        if (StringUtils.isNotBlank(screenName) && StringUtils.isNotBlank(email)) {
            UserDO temp = new UserDO();
            temp.setId(users.getId());
            temp.setScreenName(screenName);
            temp.setEmail(email);
            userService.updateById(temp);
            logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), null,request.getRemoteAddr
                    (), this.getUid(request));

            //更新session中的数据
            UserDO original = (UserDO) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
            original.setScreenName(screenName);
            original.setEmail(email);
            session.setAttribute(WebConst.LOGIN_SESSION_KEY, original);
        }
        return RestResponseBo.ok();
    }

    /**
     * 修改密码
     */
    @PostMapping(value = "/password")
    @ResponseBody
    public RestResponseBo upPwd(@RequestParam String oldPassword, @RequestParam String password, HttpServletRequest
            request, HttpSession session) {
        UserDO users = this.user(request);
        if (StringUtils.isBlank(oldPassword) || StringUtils.isBlank(password)) {
            return RestResponseBo.fail("请确认信息输入完整");
        }

        if (!users.getPassword().equals(TaleUtils.md5encode(users.getLoginName() + oldPassword))) {
            return RestResponseBo.fail("旧密码错误");
        }
        if (password.length() < 6 || password.length() > 14) {
            return RestResponseBo.fail("请输入6-14位密码");
        }

        try {
            UserDO temp = new UserDO();
            temp.setId(users.getId());
            String pwd = TaleUtils.md5encode(users.getLoginName() + password);
            temp.setPassword(pwd);
            userService.updateById(temp);
            logService.insertLog(LogActions.UP_PWD.getAction(), null,null, request.getRemoteAddr(), this.getUid(request));

            //更新session中的数据
            UserDO original = (UserDO) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
            original.setPassword(pwd);
            session.setAttribute(WebConst.LOGIN_SESSION_KEY, original);
            return RestResponseBo.ok();
        } catch (Exception e) {
            String msg = "密码修改失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                LOGGER.error(msg, e);
            }
            return RestResponseBo.fail(msg);
        }
    }
}
