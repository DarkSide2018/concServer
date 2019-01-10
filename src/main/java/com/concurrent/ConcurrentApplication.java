package com.concurrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConcurrentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ConcurrentApplication.class, args);
     }
}



