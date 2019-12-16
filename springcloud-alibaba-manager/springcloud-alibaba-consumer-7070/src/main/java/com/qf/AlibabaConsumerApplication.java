package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.swing.*;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaConsumerApplication.class, args);
    }
}
