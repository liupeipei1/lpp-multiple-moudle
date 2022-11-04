package com.example.springeuraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringEurakaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEurakaApplication.class, args);
    }

}
