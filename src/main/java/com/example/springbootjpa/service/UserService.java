package com.example.springbootjpa.service;


import com.example.springbootjpa.po.User;

import java.util.List;

public interface UserService {

    User findByUsernameAndPWD(User user);

    List<User> findUsers();

    User findUserById(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);
}
