package com.dachuang;

import com.dachuang.dao.UserDao.UserMapper;
import com.dachuang.domin.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GitDachangApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }
    @Test
    public void selectUserByEmail()
    {
       User user = userMapper.selectUserByEmail("2762999285@qq.com");
        System.out.println(user);
    }
    @Test
    public void registerUser()
    {
        User user = new User("wwj","15963@qq.com","123456");
        userMapper.registerUser(user);

    }
}
