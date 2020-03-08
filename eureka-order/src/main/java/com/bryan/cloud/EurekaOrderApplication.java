package com.bryan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * # 刷新配置url POST  http://localhost:8300/actuator/refresh 这种每个节点都要调用一次 （很鸡肋）
 * # 刷新配置url POST  http://localhost:8300/actuator/bus-refresh  bus这种只要在任意一个bus节点调用一次就可以，会广播给各个节点
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaOrderApplication.class, args);
    }

}
