package com.sonnx.blog.interceptor;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Component;

/**
 * 拦截mybatis格式化输出sql 项目名称:咪咕合管 包名称: com.migu.tsg.pms.platform.component.core.pagination.mybatis.interceptor 类名称:
 * MybatisSqlInterceptor 类描述: 创建人: zhuxiaolong@aspirecn.com 创建时间:2017年9月7日 下午5:32:21 版本： V1.0.0
 */
 @Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
 @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
 RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})})
 @Component
public class MybatisSqlInterceptor implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisSqlInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = null;
        int argsLength = 1;
        if (invocation.getArgs().length > argsLength) {
            parameter = invocation.getArgs()[1];
        }
        String sqlId = mappedStatement.getId();
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        Configuration configuration = mappedStatement.getConfiguration();
        Object returnValue;
        long start = System.currentTimeMillis();
        returnValue = invocation.proceed();
        long end = System.currentTimeMillis();
        long time = (end - start);
        int timeSize = 1;
        if (time > timeSize) {
            String sql = getSql(configuration, boundSql, sqlId, time, returnValue);
            LOGGER.info(sql);
        }
        return returnValue;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

    public static String getSql(Configuration configuration, BoundSql boundSql, String sqlId, long time,
            Object returnValue) {
        String sql = showSql(configuration, boundSql);
        StringBuilder str = new StringBuilder();
        str.append("\n");
        str.append(rightPad("==============================MIGU-NET_PMS1.0.0.0", "=", 123) + "\n");

        str.append(rightPad("[    SQL   ID]:\t", " ", 15) + rightPad(sqlId, " ", 120) + "\n");
        str.append(rightPad("[         SQL]:\t", " ", 15) + rightPad(sql, " ", 120) + "\n");
        if (returnValue instanceof List) {
            List value = (List) returnValue;
            str.append(
                    rightPad("[RETURN TOTAL]:\t", " ", 15) + rightPad(String.valueOf(value.size()), " ", 120) + "\n");
            String tmp = JSONArray.toJSONString(value);

            str.append(rightPad("[RETURN  DATA]:\t", " ", 15) + rightPad(tmp, " ", 120) + "\n");
        } else if (returnValue instanceof Integer || returnValue instanceof Long) {
            str.append(rightPad("[RETURN TOTAL]:\t", " ", 15) + rightPad(String.valueOf(returnValue), " ", 120) + "\n");
            str.append(rightPad("[RETURN  DATA]:\t", " ", 15) + rightPad(String.valueOf(returnValue), " ", 120) + "\n");
        }
        str.append(rightPad("[WASTE   TIME]:\t", " ", 15) + rightPad(time + "(ms)", " ", 120) + "\n");

        str.append(rightPad("=", "=", 123) + "\n");
        return str.toString();
    }

    private static String getParameterValue(Object obj) {
        String value;
        if (obj instanceof String) {
            value = "'" + obj.toString() + "'";
        } else if (obj instanceof Date) {
            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
            value = "'" + formatter.format(new Date()) + "'";
        } else {
            if (obj != null) {
                value = obj.toString();
            } else {
                value = "";
            }

        }
        return value;
    }

    public static String showSql(Configuration configuration, BoundSql boundSql) {
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
        if (parameterMappings.size() > 0 && parameterObject != null) {
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                sql = replaceFirst("\\?", sql, getParameterValue(parameterObject));

            } else {
                MetaObject metaObject = configuration.newMetaObject(parameterObject);
                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();
                    if (metaObject.hasGetter(propertyName)) {
                        Object obj = metaObject.getValue(propertyName);
                        sql = replaceFirst("\\?", sql, getParameterValue(obj));
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        Object obj = boundSql.getAdditionalParameter(propertyName);
                        sql = replaceFirst("\\?", sql, getParameterValue(obj));
                    }
                }
            }
        }
        return sql;
    }

    private static String leftPad(String result, String padChar, int size) {
        return StringUtils.leftPad(result, size, padChar);
    }

    private static String rightPad(String result, String padChar, int size) {
        return StringUtils.rightPad(result, size, padChar);
    }

    private static String replaceFirst(String regex, String sql, String param) {
        param = param.replace("$", "REGEX_DOLLAR");
        sql = sql.replaceFirst(regex, param);
        return sql.replace("REGEX_DOLLAR", "$");
    }
}
