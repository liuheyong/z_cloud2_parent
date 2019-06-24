package com.cloud2.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZCloud2Gateway2Application {

    public static void main(String[] args) {
        SpringApplication.run(ZCloud2Gateway2Application.class, args);
    }

}
