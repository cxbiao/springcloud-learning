package com.bryan.cloud;

import com.bryan.cloud.bean.Fruit;
import com.bryan.cloud.service.impl.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    private MessageSender messageSender;

    @RequestMapping("/send")
    public String send(){
        Fruit fruit = new Fruit();
        fruit.setId(1);
        fruit.setName("apple");
        fruit.setMoney(2.2);
        messageSender.send(fruit);
        System.out.println("ok");
        return "ok";
    }
}
