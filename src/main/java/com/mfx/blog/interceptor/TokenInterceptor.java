package com.mfx.blog.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.mfx.blog.component.common.AdminCommons;
import com.mfx.blog.component.common.Commons;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.service.LogService;
import com.mfx.blog.service.OptionService;
import com.mfx.blog.service.UserService;
import com.mfx.blog.utils.MapCache;
import com.mfx.blog.utils.MfxCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义拦截器
 *
 * @author mfx
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
        // 放入本地缓存,便于service 和controller访问
        if (MfxCache.get() == null) {
            MfxCache.set(userDO);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
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
