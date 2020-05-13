package com.friendship41.song4music.common.config;

import com.friendship41.song4music.common.interceptor.LogInterceptor;
import com.friendship41.song4music.common.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer
{
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/test/**/")
                .excludePathPatterns("/login")
                .excludePathPatterns("/kakao_oauth")
                .excludePathPatterns("/error");
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/test/**/")
                .excludePathPatterns("/loginPage")
                .excludePathPatterns("/login")
                .excludePathPatterns("/kakao_oauth")
                .excludePathPatterns("/error");
    }
}
