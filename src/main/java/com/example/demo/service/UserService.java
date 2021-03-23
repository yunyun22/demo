package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

/**
 * @author wang, jinqiao
 * @date 23/03/2021
 */
public interface UserService {

    /**
     * 用户列表
     *
     * @param user 用户
     * @return 用户列表
     */
    List<User> getUserByEntity(User user);
}
