package com.bryan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
post
* 加密：POST http://localhost:8500/encrypt
* 解密：POST http://localhost:8500/decrypt
  刷新配置url POST  http://localhost:8500/actuator/bus-refresh

  获得配置  http://localhost:8500/api-zuul.json
* */

@SpringBootApplication
@EnableConfigServer
// 注册到eureka
@EnableEurekaClient
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
