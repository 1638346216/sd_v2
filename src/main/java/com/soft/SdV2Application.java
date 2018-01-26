package com.soft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.soft.dao")
public class SdV2Application {
    public static void main(String[] args) {
        SpringApplication.run(SdV2Application.class, args);
    }
}
