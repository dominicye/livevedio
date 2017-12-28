package com.ways.live.common;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebFilterConfig {

    @Bean
    public FilterRegistrationBean contextFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(loginFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("LoginFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public Filter loginFilter() {
        return new LoginFilter();
    }

}
