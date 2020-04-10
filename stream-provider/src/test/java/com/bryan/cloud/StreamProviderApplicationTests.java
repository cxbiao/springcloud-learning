package com.bryan.cloud;

import com.bryan.cloud.bean.Fruit;
import com.bryan.cloud.service.impl.MessageSender;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
class StreamProviderApplicationTests {

    @Resource
    private MessageSender messageProvider;


    /**
     * 单元测试不行，要容器启动完成才能发
     * @throws IOException
     */
    @Test
    public void testSend() throws IOException {
        Fruit fruit = new Fruit();
        fruit.setId(1);
        fruit.setName("apple");
        fruit.setMoney(2.2);
        messageProvider.send(fruit);
        System.out.println("ok");

      System.in.read();


    }


}
