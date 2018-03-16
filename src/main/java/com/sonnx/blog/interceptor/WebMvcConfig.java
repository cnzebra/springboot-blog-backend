package com.sonnx.blog.interceptor;


import com.sonnx.blog.utils.TaleUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * 向mvc中添加自定义组件
 *
 * @author sonnx
 * @date 2017/3/9
 */
@Component
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Resource
    private BaseInterceptor baseInterceptor;
    @Resource
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截携带token的请求
        // 拦截器的执行顺序和这里配置的顺序相同
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**/*.token");
        registry.addInterceptor(baseInterceptor);
    }

    /**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + TaleUtils.getUplodFilePath() +
                "upload/");
        super.addResourceHandlers(registry);
    }
}
