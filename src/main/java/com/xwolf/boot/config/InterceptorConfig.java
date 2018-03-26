package com.xwolf.boot.config;

import com.xwolf.boot.interceptor.CsrfInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置
 * @author xwolf
 * @version 1.0
 * @since 1.8
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    /**
     * CSRF拦截
     * @return
     */
    @Bean
    CsrfInterceptor csrfInterceptor(){
        return new CsrfInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(csrfInterceptor()).addPathPatterns("/");
    }
}
