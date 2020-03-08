package com.bryan.cloud.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//注册到eureka
@EnableEurekaClient
//开启断路器功能
@EnableCircuitBreaker
@EnableFeignClients
//开启feign支持，clients指定哪个类开启feign
//@EnableFeignClients(clients = {StudentService.class, TeacherServiceFeign.class})
public class EurekaWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaWebApplication.class, args);
    }

}
