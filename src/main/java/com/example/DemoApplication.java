package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.example.mapper")
@SpringBootApplication
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
