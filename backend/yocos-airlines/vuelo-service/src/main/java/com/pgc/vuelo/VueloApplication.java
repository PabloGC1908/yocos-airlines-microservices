package com.pgc.vuelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class VueloApplication {
    public static void main(String[] args) {
        SpringApplication.run(VueloApplication.class, args);
    }
}