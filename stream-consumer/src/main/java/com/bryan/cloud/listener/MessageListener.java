package com.bryan.cloud.listener;


import com.bryan.cloud.bean.Fruit;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(DefaultProcess.class)
public class MessageListener {
    @StreamListener(DefaultProcess.INPUT)
    public void input(Message<Fruit> message) {
        System.err.println("【*** 消息接收 ***】" + message.getPayload());
    }

}
