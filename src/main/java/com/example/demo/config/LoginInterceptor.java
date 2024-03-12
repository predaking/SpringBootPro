package com.example.demo.config;

import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    private final UserService userService;

    public LoginInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!userService.isLogin(request.getSession()).isSuccess()) {
            System.out.println("用户尚未登录");
            return false;
        }

        return true;
    }
}
