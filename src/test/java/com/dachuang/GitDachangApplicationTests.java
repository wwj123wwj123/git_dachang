package com.dachuang;

import cn.hutool.core.io.FileUtil;
import com.dachuang.entity.user.po.UserDO;
import com.dachuang.mapper.user.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GitDachangApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDO userDO;
    @Test
    void contextLoads() {
    }
    @Test
    public void selectUserByEmail()
    {
        userDO = userMapper.selectUserByEmail("2762999285@qq.com");
        System.out.println(userDO);
    }
    @Test
    public void registerUser()
    {
        userDO =UserDO.builder()
                .userName("wwj")
                .email("15963@qq.com")
                .password("123456")
                .build();
        userMapper.insert(userDO);
    }
    @Test
    public void testUpLoad()
    {
        String s = "2023年西安理工大学大创项目重点领域项目范围指南.doc";
//        String substring = s.substring(s.lastIndexOf('.') + 1);
//        System.out.println(substring);
    }
    @Test
    public void testDownload()
    {
        String basePath ="D:/大创/网站/";
        List<String> fileNames = FileUtil.listFileNames(basePath);
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }
}
