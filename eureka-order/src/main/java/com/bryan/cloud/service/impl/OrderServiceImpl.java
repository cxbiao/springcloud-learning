package com.bryan.cloud.service.impl;


import com.bryan.cloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {



    @Override
    public String queryOrder() {
        log.info("queryOrder succcess");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "queryOrder succcess";
    }
}
