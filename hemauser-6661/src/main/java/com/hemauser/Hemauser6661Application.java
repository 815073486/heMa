package com.hemauser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.hemauser.userdao")
@EnableDiscoveryClient
@SpringBootApplication
public class Hemauser6661Application {

    public static void main(String[] args) {
        SpringApplication.run(Hemauser6661Application.class, args);
    }

}
