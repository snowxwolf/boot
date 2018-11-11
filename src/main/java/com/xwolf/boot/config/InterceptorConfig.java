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
     * 拦截白名单
     */
    private static final String[] EXCLUDE_PATH={"/swagger-ui.html","/swagger-resources/**","/v2/api-docs"};

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

        registry.addInterceptor(csrfInterceptor()).addPathPatterns("/**").excludePathPatterns(EXCLUDE_PATH);

        registry.addInterceptor(errorInterceptor()).addPathPatterns("/**").excludePathPatterns(EXCLUDE_PATH);
        super.addInterceptors(registry);
    }
}
