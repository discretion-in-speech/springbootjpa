package com.example.springbootjpa.controller;

import com.example.springbootjpa.componts.R;
import com.example.springbootjpa.po.User;
import com.example.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public R findAll(){
        List<User> users = userService.findUsers();

        if (!ObjectUtils.isEmpty(users)) {
            return R.SUCCESS(users);
        } else {
            return R.FAILED(null);
        }

    }

}
