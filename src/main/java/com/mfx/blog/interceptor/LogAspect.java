package com.mfx.blog.interceptor;

import com.mfx.blog.annotation.LogAnnotation;
import com.mfx.blog.modal.entity.LogDO;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.service.LogService;
import com.mfx.blog.thread.UserThreadLocal;
import com.mfx.blog.utils.ClientUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * 日志记录AOP
 *
 * @author wangq
 * @date 2017/3/24
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private LogService logService;

    @Pointcut("execution(public * com.mfx.blog.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint point) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String targetName = point.getTarget().getClass().getName();
        Class targetClass = Class.forName(targetName);
        String methodName = point.getSignature().getName();
        Method[] method = targetClass.getMethods();
        Object[] params = point.getArgs(); // 获得参数列表
        for (Method m : method) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == params.length) {
                    LogDO logDO = new LogDO();
                    // 获取注解内容
                    LogAnnotation logAnnotation = m.getAnnotation(LogAnnotation.class);
                    if (logAnnotation != null) {
                        // 获取动作
                        String action = logAnnotation.action().getAction();
                        logDO.setAction(action);
                        // 获取操作数据
                        String data = logAnnotation.data();
                        // 填充变量数据
                        while (data.indexOf("#") != -1) {
                            Integer index = Integer.parseInt(data.substring(data.indexOf("#") + 1, data.indexOf("#") + 2));
                            data = data.replaceFirst("#" + index, "" + params[index - 1]);
                        }
                        logDO.setData(data);
                        // 获取日志级别
                        int level = logAnnotation.level().getLevel();
                        logDO.setLevel(level);
                        // 获取作者
                        UserDO userDO = UserThreadLocal.get();
                        if (userDO != null) {
                            Long authorId = userDO.getId();
                            String authorName = userDO.getLoginName();
                            logDO.setAuthorId(authorId);
                            logDO.setAuthor(authorName);

                        } else {
                            logDO.setAuthor("游客");
                        }
                        logDO.setIp(ClientUtils.getIp(request));
                        logDO.setUrl(ClientUtils.getUri(request));
                        logDO.setBrowser(ClientUtils.getBrowser(request));
                        logDO.setGmtCreate(new Date());
                        logService.insertLog(logDO);
                        break;
                    }
                }
            }

        }
    }

    @AfterReturning(returning = "object", pointcut = "webLog()")
    public void doAfterReturning(Object object) throws Throwable {
        // 处理完请求，返回内容
        LOGGER.info("RESPONSE : " + object);
    }
}
