package com.bryan.cloud.web.controller;

import com.bryan.cloud.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {



   @Autowired
   private OrderService orderService;

    public static boolean canDbUse=true;

    @RequestMapping("/queryOrder")
    public String queryOrder(){
        return orderService.queryOrder();
    }


    @RequestMapping("/db/{can}")
    public String setDbStatus(@PathVariable  boolean can){
        canDbUse=can;
        return "ok";
    }

}
