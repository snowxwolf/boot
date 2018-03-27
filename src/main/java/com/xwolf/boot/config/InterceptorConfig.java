package com.xwolf.boot.config;

import com.xwolf.boot.interceptor.CsrfInterceptor;
import com.xwolf.boot.interceptor.ErrorInterceptor;
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
    /**
     * 错误拦截
     * @return
     */
    @Bean
    ErrorInterceptor errorInterceptor(){
        return new ErrorInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(csrfInterceptor()).addPathPatterns("/**");

        registry.addInterceptor(errorInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
