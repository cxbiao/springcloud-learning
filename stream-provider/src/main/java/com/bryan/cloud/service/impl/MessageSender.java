package com.bryan.cloud.service.impl;

import com.bryan.cloud.bean.Fruit;
import com.bryan.cloud.service.DefaultProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(DefaultProcess.class)
public class MessageSender {

    @Autowired
    private MessageChannel bryan_output;  // 消息的发送管道


    public void send(Fruit fruit) {
        bryan_output.send(MessageBuilder.withPayload(fruit).build());
    }


}
