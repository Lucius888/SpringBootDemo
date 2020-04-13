package com.lucius;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lucius.Dao")
public class Springboot09ShiroThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09ShiroThymeleafApplication.class, args);
    }

}
