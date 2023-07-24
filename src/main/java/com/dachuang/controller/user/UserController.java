package com.dachuang.controller.user;

import com.dachuang.entity.user.dto.UserDTO;
import com.dachuang.service.user.UserService;
import com.dachuang.util.HttpResult;
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
     * @param userDTO
     * @return
     * @param <userDto>
     */
    @PostMapping("/user/login")
    public <userDto> HttpResult login(@RequestBody UserDTO userDTO)
    {
        return userService.login(userDTO);
    }

    /**
     * 注册接口
     * @param userDTO
     * @return
     */
    @PostMapping("/user/register")
    public HttpResult register(@RequestBody UserDTO userDTO)
    {
        return userService.register(userDTO);
    }
}
