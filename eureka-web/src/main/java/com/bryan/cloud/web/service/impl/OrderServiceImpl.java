package com.bryan.cloud.web.service.impl;

import com.bryan.cloud.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVICE_NAME="micro-order";

    @Override
    public String queryOrder() {
        String ret=restTemplate.getForObject("http://"+SERVICE_NAME+"/order/queryOrder",String.class);
        return ret;
    }
}
