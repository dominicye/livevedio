package com.ways.live.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class VedioSourceConfigure extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        System.out.println("---------------- System load this class ------------------------------");
        registry.addResourceHandler("/waysVedio/**").addResourceLocations("file:C:/waysVedio/");
        super.addResourceHandlers(registry);
    }
}
