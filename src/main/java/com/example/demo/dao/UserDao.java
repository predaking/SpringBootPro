package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findUserByUid(Long uid);
    User findUserByUname(String uname);
    User findUserByUnameAndPassword(String uname, String password);

    User findUserByIp(String ip);
}
