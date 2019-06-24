package com.cloud2.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZCloud2GatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZCloud2GatewayApplication.class).web(true).run(args);
    }

}
