package com.cloud2.swagger;

import com.cloud2.commons.constants.Constants;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableSwagger2Doc
@EnableDiscoveryClient
@SpringBootApplication
public class ZCloud2SwaggerAApplication {

    private static Logger logger = LoggerFactory.getLogger(ZCloud2SwaggerAApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZCloud2SwaggerAApplication.class).web(true).run(args);
    }

    @RestController
    class AaaController {

        @Autowired
        DiscoveryClient discoveryClient;

        @GetMapping(Constants.CLOUD2 + "/service-a")
        public String dc() {
            String services = "Services: " + discoveryClient.getServices();
            logger.info(services);
            return services;
        }

    }

}
