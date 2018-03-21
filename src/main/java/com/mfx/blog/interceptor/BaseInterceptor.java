package com.mfx.blog.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.mfx.blog.component.common.AdminCommons;
import com.mfx.blog.component.common.Commons;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.Types;
import com.mfx.blog.modal.entity.OptionDO;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.service.LogService;
import com.mfx.blog.service.OptionService;
import com.mfx.blog.service.UserService;
import com.mfx.blog.utils.AbstractUUID;
import com.mfx.blog.utils.IPKit;
import com.mfx.blog.utils.MapCache;
import com.mfx.blog.utils.TaleUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 自定义拦截器
 *
 * @author mfx
 * @date 2017/3/9
 */
@Component
public class BaseInterceptor implements HandlerInterceptor {
    private static final Logger LOGGE = LoggerFactory.getLogger(BaseInterceptor.class);

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
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();


        //设置get请求的token
        if ("GET".equals(request.getMethod())) {
            String csrfToken = AbstractUUID.uu64();
            // 默认存储30分钟
            cache.hset(Types.CSRF_TOKEN.getType(), csrfToken, uri, 30 * 60);
            request.setAttribute("csrfToken", csrfToken);
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
}
