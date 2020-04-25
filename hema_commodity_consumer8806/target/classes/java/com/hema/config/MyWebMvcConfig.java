package com.hema.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyWebMvcConfig
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/10 18:42
 * @Version 1.0
 **/
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

            registry.addResourceHandler("/static/**");
            registry.addResourceHandler("classpath:/static/index.html");

    }

}
