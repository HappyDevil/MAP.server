package com.mapProject.server.service;


import com.mapProject.server.entity.User;

public interface UserService {

    User findUserByUsername(String username);
    User save(User user);
}
