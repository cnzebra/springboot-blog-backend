package com.mfx.blog.utils;

import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;

public class ClientUtils {

    private static final String USER_AGENT = "User-Agent";


    public static String getBrowser(HttpServletRequest request) {
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader(USER_AGENT));
        if (userAgent != null) {
            return userAgent.getBrowser().toString();
        }
        return null;
    }

    public static String getUrl(HttpServletRequest request) {
        return request.getRequestURL().toString();
    }

    public static String getUri(HttpServletRequest request) {
        return request.getRequestURI();
    }

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-real-ip");//先从nginx自定义配置获取
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
