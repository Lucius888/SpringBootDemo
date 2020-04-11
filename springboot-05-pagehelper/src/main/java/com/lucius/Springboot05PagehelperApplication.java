package com.lucius;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lucius.dao")
public class Springboot05PagehelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot05PagehelperApplication.class, args);
    }

}
