package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;

    public static final String SESSION_NAME = "userInfo";

    @PostMapping("/register")
    public Result<User> registerController(@RequestBody User _user, HttpServletRequest request) {
        _user.setIp(request.getHeader("X-Real-IP"));
        return userService.register(_user);
    }

    @PostMapping("/login")
    public Result<User> loginController(@RequestBody User user, HttpServletRequest request) {
        return userService.login(user, request.getSession());
    }

    @GetMapping("/isLogin")
    public  Result<User> isLoginController(HttpServletRequest request) {
        return userService.isLogin(request.getSession());
    }
}
