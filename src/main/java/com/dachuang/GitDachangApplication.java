package com.dachuang;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.dachuang.*")
public class GitDachangApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitDachangApplication.class, args);
    }

}
