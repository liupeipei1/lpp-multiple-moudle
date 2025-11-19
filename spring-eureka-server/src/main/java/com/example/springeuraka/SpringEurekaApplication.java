package com.example.springeuraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableDiscoveryClient
@SpringBootApplication(exclude = {GsonAutoConfiguration.class})
@EnableEurekaServer
public class SpringEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaApplication.class, args);
    }

}
