package com.sonnx.blog.interceptor;

import com.sonnx.blog.dto.Types;
import com.sonnx.blog.component.common.AdminCommons;
import com.sonnx.blog.component.common.Commons;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.dto.Types;
import com.sonnx.blog.modal.entity.OptionDO;
import com.sonnx.blog.modal.entity.UserDO;
import com.sonnx.blog.service.OptionService;
import com.sonnx.blog.service.UserService;
import com.sonnx.blog.utils.AbstractUUID;
import com.sonnx.blog.utils.IPKit;
import com.sonnx.blog.utils.MapCache;
import com.sonnx.blog.utils.TaleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 *
 * @author sonnx
 * @date 2017/3/9
 */
@Component
public class BaseInterceptor implements HandlerInterceptor {
    private static final Logger LOGGE = LoggerFactory.getLogger(BaseInterceptor.class);
    private static final String USER_AGENT = "user-agent";

    @Resource
    private UserService userService;

    @Resource
    private OptionService optionService;

    private MapCache cache = MapCache.single();

    @Resource
    private Commons commons;

    @Resource
    private AdminCommons adminCommons;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();

        LOGGE.info("UserAgent: {}", request.getHeader(USER_AGENT));
        LOGGE.info("用户访问地址: {}, 来路地址: {}", uri, IPKit.getIpAddrByRequest(request));


        //请求拦截处理
        UserDO user = TaleUtils.getLoginUser(request);
        if (null == user) {
            Long userId = TaleUtils.getCookieUid(request);
            if (null != userId) {
                //这里还是有安全隐患,cookie是可以伪造的
                user = userService.queryUserById(userId);
                request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            }
        }
        if (uri.startsWith("/admin") && !uri.startsWith("/admin/login") && null == user) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }
        //设置get请求的token
        if ("GET".equals(request.getMethod())) {
            String csrfToken = AbstractUUID.uu64();
            // 默认存储30分钟
            cache.hset(Types.CSRF_TOKEN.getType(), csrfToken, uri, 30 * 60);
            request.setAttribute("_csrf_token", csrfToken);
        }
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
}
