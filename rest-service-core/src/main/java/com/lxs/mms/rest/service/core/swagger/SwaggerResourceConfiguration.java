package com.lxs.mms.rest.service.core.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 加载Swagger静态资源，子模块引用不会加载其他jar中的静态resource，手动添加一下。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Configuration
public class SwaggerResourceConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger/**")
                .addResourceLocations("classpath:/static/swagger/");
    }
}
