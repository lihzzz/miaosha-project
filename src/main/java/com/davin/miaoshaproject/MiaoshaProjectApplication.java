package com.davin.miaoshaproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.davin"})
@MapperScan("com.davin.miaoshaproject.dao")
public class MiaoshaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiaoshaProjectApplication.class, args);
    }

}
