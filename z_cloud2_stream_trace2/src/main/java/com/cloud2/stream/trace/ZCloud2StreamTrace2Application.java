package com.cloud2.stream.trace;

import com.cloud2.commons.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@EnableEurekaClient
@RestController
@SpringBootApplication
public class ZCloud2StreamTrace2Application {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {

        SpringApplication.run(ZCloud2StreamTrace2Application.class, args);
    }

    @RequestMapping(value = Constants.CLOUD2 + "/trace-2", method = RequestMethod.GET)
    public String trace(HttpServletRequest request) {
        logger.info("==========<call trace-2, TraceId={}, SpanId={}>==========", request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
        return "Trace";
    }

}
