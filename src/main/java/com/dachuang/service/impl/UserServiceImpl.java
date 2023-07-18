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

    /**
     *
     * @param user
     * @return Result
     * 登录实现
     */
    @Override
    public Result login(User user) {
        User user1 = userMapper.selectUserByEmail(user.getEmail());
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

    /**
     * 注册实现
     * @param user
     * @return
     */
    @Override
    public Result register(User user) {
        User user1 = userMapper.selectUserByEmail(user.getEmail());
        if(user1!=null)
        {
            return new Result(Code.UPDATE_Err,user,"用户已存在！");
        }

        return userMapper.registerUser(user)>0?new Result(Code.UPDATE_OK,user,"注册成功！"):new Result(Code.UPDATE_Err,user,"注册失败！");
    }

    @Override
    public boolean selectUserByEmail(String email) {
        return userMapper.selectUserByEmail(email)!=null;
    }
}
