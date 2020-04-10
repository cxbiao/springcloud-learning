package com.bryan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


/**
 *
 * turbine监控地址：http://localhost:9101/turbine.stream
 *
 * 启动Dashboard:		http://localhost:9100/hystrix
 * 在Dashboard里面填上 turbine监控地址
 *
 *可以同时监控多个服务
 */
@EnableTurbine
@SpringBootApplication
public class TurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class, args);
    }

}
