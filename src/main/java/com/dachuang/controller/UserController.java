package com.dachuang.controller;

import com.dachuang.controller.common.Result;
import com.dachuang.domin.User;
import com.dachuang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user/login")
    public <user> Result login(@RequestBody User user)
    {
        System.out.println("1");
        return userService.login(user);
    }
}
