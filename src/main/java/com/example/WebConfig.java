package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(CookieInterceptor())
                .addPathPatterns("/**") //添加需要拦截的url
                .excludePathPatterns("/user/login") //添加不需要拦截的url，白名单
                .excludePathPatterns("/facility/*")
                .excludePathPatterns("/command/*")
                .excludePathPatterns("/images/*");
    }

    @Bean
    public CookieInterceptor CookieInterceptor() {
        return new CookieInterceptor();
    }
}