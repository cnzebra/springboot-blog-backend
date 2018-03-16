package com.sonnx.blog.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.sonnx.blog.component.common.AdminCommons;
import com.sonnx.blog.component.common.Commons;
import com.sonnx.blog.dto.Types;
import com.sonnx.blog.modal.bo.RestResponseBo;
import com.sonnx.blog.modal.entity.OptionDO;
import com.sonnx.blog.modal.entity.UserDO;
import com.sonnx.blog.service.LogService;
import com.sonnx.blog.service.OptionService;
import com.sonnx.blog.service.UserService;
import com.sonnx.blog.thread.UserThreadLocal;
import com.sonnx.blog.utils.AbstractUUID;
import com.sonnx.blog.utils.IPKit;
import com.sonnx.blog.utils.MapCache;
import com.sonnx.blog.utils.TaleUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 自定义拦截器
 *
 * @author sonnx
 * @date 2017/3/9
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    private static final Logger LOGGE = LoggerFactory.getLogger(TokenInterceptor.class);
    private static final String USER_AGENT = "User-Agent";

    @Resource
    private UserService userService;

    @Resource
    private OptionService optionService;

    private MapCache cache = MapCache.single();

    @Resource
    private Commons commons;

    @Resource
    private AdminCommons adminCommons;

    @Autowired
    private LogService logService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        UserDO userDO = userService.queryUserByToken(token);
        if (userDO == null) {
            this.responseData(response, RestResponseBo.fail(403, "禁止访问"));
            return false;
        }
        // 放入本地线程,便于service 和controller访问
        UserThreadLocal.set(userDO);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        OptionDO ov = optionService.getOptionByName("site_record");
        // 一些工具类和公共方法
        httpServletRequest.setAttribute("commons", commons);
        httpServletRequest.setAttribute("option", ov);
        httpServletRequest.setAttribute("adminCommons", adminCommons);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }


    private void responseData(HttpServletResponse response, RestResponseBo responseBo) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(JSONObject.toJSONString(responseBo));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
