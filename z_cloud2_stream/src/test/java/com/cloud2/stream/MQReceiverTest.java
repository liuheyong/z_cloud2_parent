package com.cloud2.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: HeYongLiu
 * @create: 06-25-2019
 * @description:
 **/
@RunWith(SpringRunner.class)
@EnableBinding(value = {MQReceiverTest.MQSender.class})
public class MQReceiverTest {

    @Autowired
    private MQSender mqSender;

    @Test
    public void sinkSenderTester() {
        mqSender.output().send(MessageBuilder.withPayload("produce a message").build());
    }

    public interface MQSender {

        String OUTPUT = "input";

        @Output(MQReceiverTest.MQSender.OUTPUT)
        MessageChannel output();

    }

}