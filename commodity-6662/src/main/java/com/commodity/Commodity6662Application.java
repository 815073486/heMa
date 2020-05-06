package com.commodity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@MapperScan("com.commodity.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class Commodity6662Application {

    public static void main(String[] args) {
        SpringApplication.run(Commodity6662Application.class, args);
    }


}
