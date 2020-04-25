package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HemaCommodityProvider8805Application {

    public static void main(String[] args) {
        SpringApplication.run(HemaCommodityProvider8805Application.class, args);
    }

}
