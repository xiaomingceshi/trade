package com.cloud.cloudbootconsumertrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.cloud.service"})
public class CloudBootConsumerTradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudBootConsumerTradeApplication.class, args);
    }

}
