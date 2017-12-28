package com.ways.live;

import com.ways.live.intercept.ClickTimeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    ClickTimeFilter clickTimeFilter() {
        return new ClickTimeFilter();
    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(clickTimeFilter());
        registration.addUrlPatterns("/*");
        registration.setName("clickTimeFilter");
        return registration;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        System.out.println("---------------- System load this class ------------------------------");
        registry.addResourceHandler("/waysVedio/**").addResourceLocations("file:C:/waysVedio/");
        super.addResourceHandlers(registry);
    }

}