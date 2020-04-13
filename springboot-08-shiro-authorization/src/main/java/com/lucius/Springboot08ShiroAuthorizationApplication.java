package com.lucius;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lucius.Dao")
public class Springboot08ShiroAuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot08ShiroAuthorizationApplication.class, args);
    }

}
