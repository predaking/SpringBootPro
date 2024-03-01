package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.util.Result;
import jakarta.servlet.http.HttpSession;

public interface UserService {
    Result<User> register(User user);
    Result<User> login(User user, HttpSession httpSession);

    Result<User> isLogin(HttpSession httpSession);
}
