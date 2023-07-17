package com.dachuang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dachuang.dao")
public class GitDachangApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitDachangApplication.class, args);
    }

}
