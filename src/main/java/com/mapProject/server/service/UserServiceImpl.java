package com.mapProject.server.service;


import com.mapProject.server.entity.User;
import com.mapProject.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String username) {
        return userRepository.findOne(username);
    }

    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }
}
