package com.cloud2.config;

import com.cloud2.commons.constants.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ZCloud2ConfigClientDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZCloud2ConfigClientDbApplication.class, args);
    }

    @RefreshScope
    @RestController
    class TestController {

        @Value("${com.didispace.message}")
        private String message;

        @GetMapping(Constants.CLOUD2 + "/test")
        public String test() {
            return message;
        }

    }

}
