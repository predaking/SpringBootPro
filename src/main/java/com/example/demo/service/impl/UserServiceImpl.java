package com.example.demo.service.impl;

import com.example.demo.controller.UserController;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public Result<User> register(User user) {
        if (userDao.findUserByIp(user.getIp()) != null) {
            return Result.error(40010, "同一个ip不能重复注册");
        } else if (userDao.findUserByUname(user.getUname()) != null) {
            return Result.error(40011, "该用户已注册");
        } else {
            userDao.save(user);
            return Result.success();
        }
    }

    public Result<User> login(User _user, HttpSession httpSession) {
        User user = userDao.findUserByUnameAndPassword(_user.getUname(), _user.getPassword());

        if (user != null) {
            httpSession.setAttribute(UserController.SESSION_NAME, user);
            return Result.success();
        }

        return Result.error(40012, "登录失败");
    }

    public Result<User> isLogin(HttpSession httpSession) {
        User sessionUser = (User) httpSession.getAttribute(UserController.SESSION_NAME);

        if (sessionUser == null) {
            return Result.error(40013, "未登录");
        }

        User user = userDao.findUserByUid(sessionUser.getUid());

        if (user == null || !user.getPassword().equals(sessionUser.getPassword())) {
            return Result.error(40014, "登录信息无效");
        }

        return Result.success();
    }
}
