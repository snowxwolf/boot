package com.xwolf.boot.config;

import com.xwolf.boot.interceptor.XSSFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Filter注册
 * @author xwolf
 * @version 1.0
 * @since 1.8
 */
@Configuration
public class FilterConfig {

    private static final String[] URLS = {"/user/*"};

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new XSSFilter());
        filterRegistrationBean.addUrlPatterns(URLS);
        filterRegistrationBean.setName("XSSFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
