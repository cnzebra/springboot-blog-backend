package com.mfx.blog.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.controller.BaseController;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.service.LogService;
import com.mfx.blog.service.UserService;
import com.mfx.blog.utils.TaleUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户后台登录/登出
 *
 * @author mfx
 * @date 2017/3/11
 */
@Controller
@RequestMapping("/admin")
@Transactional(rollbackFor = TipException.class)
public class AuthController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Resource
    private UserService usersService;

    @Resource
    private LogService logService;

    @GetMapping(value = "/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping(value = "login")
    @ResponseBody
    public ResponseEntity doLogin(@RequestBody JSONObject loginForm, HttpServletRequest request,
                                  HttpServletResponse response) {

        Integer errorCount = cache.get("login_error_count");
        try {
            UserDO user = usersService.login(null);
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            if (StringUtils.isNotBlank(loginForm.getString("rememberMe"))) {
                TaleUtils.setCookie(response, user.getId());
            }
            logService.insertLog(LogActions.LOGIN.getAction(), null, null, request.getRemoteAddr(), user.getId());
            return new ResponseEntity(RestResponseBo.ok(user), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常信息{}", e.getMessage(), e);
            errorCount = null == errorCount ? 1 : errorCount + 1;
            if (errorCount > 3) {
                return new ResponseEntity(RestResponseBo.fail("您输入密码已经错误超过3次，请10分钟后尝试"), HttpStatus.OK);
            }
            cache.set("login_error_count", errorCount, 10 * 60);
            String msg = "登录失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                LOGGER.error(msg, e);
            }
            return new ResponseEntity(RestResponseBo.fail(msg), HttpStatus.OK);
        }
    }


    @GetMapping(value = "userInfo")
    @ResponseBody
    public ResponseEntity getUserInfo(@RequestParam String token,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {

        try {
            UserDO user = usersService.queryUserByToken(token);
            return new ResponseEntity(RestResponseBo.ok(user), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常信息{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("获取用户信息失败"), HttpStatus.OK);
        }
    }

    /**
     * 注销
     *
     * @param response
     */
    @RequestMapping("/logout")
    public ResponseEntity logout(@RequestParam String token, HttpServletResponse response, HttpServletRequest request) {
        try {
            // todo
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("注销失败", e);
            return new ResponseEntity(RestResponseBo.fail(), HttpStatus.OK);
        }
    }

}
