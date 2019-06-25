package com.cloud2.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(com.cloud2.stream.ExampleBinder.class)
public class ExampleReceiver {

    private static Logger logger = LoggerFactory.getLogger(ExampleReceiver.class);

    @StreamListener(com.cloud2.stream.ExampleBinder.NAME)
    public void receive(String payload) {
        logger.info("Received: " + payload);
    }

}