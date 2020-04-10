package com.bryan.cloud;

import com.bryan.cloud.bean.Fruit;
import com.bryan.cloud.service.impl.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

//@Configuration
public class SpringListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MessageSender messageSender;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Fruit fruit = new Fruit();
        fruit.setId(1);
        fruit.setName("apple");
        fruit.setMoney(2.2);
        messageSender.send(fruit);
        System.out.println("cloud stream send ok");
    }
}
