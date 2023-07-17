package com.dachuang.service.impl;

import com.dachuang.controller.common.Code;
import com.dachuang.controller.common.Result;
import com.dachuang.dao.UserDao.UserMapper;
import com.dachuang.domin.User;
import com.dachuang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
     @Autowired
     private UserMapper userMapper;

    @Override
    public Result login(User user) {
        System.out.println(user.getEmail());
        User user1 = userMapper.selectUserByEmail(user.getEmail());
        System.out.println(user1);
        if(user1==null)
        {
            return new Result(Code.GET_Err,user,"用户不存在！");
        }
        if(!user1.getPassword().equals(user.getPassword()))
        {
            return new Result(Code.GET_Err,user,"用户密码错误！");
        }
        return new Result(Code.GET_Err,user,"登录成功,你好"+","+user1.getUserName());
    }
    @Override
    public boolean selectUserByEmail(String email) {
        return userMapper.selectUserByEmail(email)!=null;
    }
}
