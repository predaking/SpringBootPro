package com.example.demo.config;

import com.example.demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorRegister implements WebMvcConfigurer {
    private final UserService userService;

    public InterceptorRegister(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public HandlerInterceptor getInterceptor() {
        return new LoginInterceptor(userService);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> pathPatterns = new ArrayList<>();
        pathPatterns.add("/api/user/isLogin");
        pathPatterns.add("/api/user/register");
        pathPatterns.add("/api/user/login");
        registry.addInterceptor(getInterceptor()).excludePathPatterns(pathPatterns);
    }
}
