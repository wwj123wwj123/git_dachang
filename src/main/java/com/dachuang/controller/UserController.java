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

    /**
     * 登录接口
     * @param user
     * @return
     * @param <user>
     */
    @PostMapping("/user/login")
    public <user> Result login(@RequestBody User user)
    {
        return userService.login(user);
    }

    /**
     * 注册接口
     * @param user
     * @return
     */
    @PostMapping("/user/register")
    public Result register(@RequestBody User user)
    {
        return userService.register(user);
    }
}
