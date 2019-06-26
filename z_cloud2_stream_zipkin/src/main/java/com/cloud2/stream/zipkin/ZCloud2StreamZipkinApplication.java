package com.cloud2.stream.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@EnableEurekaClient
//使用HTTP收集注解
//@EnableZipkinServer
//使用第三方消息中间件收集注解
@EnableZipkinStreamServer
@SpringBootApplication
public class ZCloud2StreamZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZCloud2StreamZipkinApplication.class, args);
    }

}
