package com.dachuang.controller.user;

import com.dachuang.entity.user.dto.UserDTO;
import com.dachuang.service.user.UserService;
import com.dachuang.util.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录接口
     * @param userDTO
     * @return
     * @param <userDto>
     */
    @PostMapping("/login")
    public <userDto> HttpResult login(@RequestBody UserDTO userDTO)
    {
        return userService.login(userDTO);
    }

    /**
     * 注册接口
     * @param userDTO
     * @return
     */
    @PostMapping("/register")
    public HttpResult register(@RequestBody UserDTO userDTO)
    {
        return userService.register(userDTO);
    }
    @PostMapping("/mange")
    public HttpResult dataManagement(Long userId){
        return userService.dataMangement(userId);
    }
}
