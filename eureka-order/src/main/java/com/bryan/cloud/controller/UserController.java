package com.bryan.cloud.controller;

import com.bryan.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Value的注解刷新需要加上  @RefreshScope ,因为@Value容器启动时就已经注入好了
 * environment 不需要加
 */

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${username}")
    private String username;

    @Value("${username1}")
    private String username1;

    @Value("${redis.password}")
    private String redispass;

    @Value("${mongodb.password}")
    private String dbpass;

    @Autowired
    Environment environment;


    @RequestMapping("/queryContent")
    public List<String> queryContent(HttpServletRequest request) {
        log.info("queryContent======");
        log.info(""+this.hashCode());
        log.info("==================已经调用==========" + request.getRemotePort());
        log.info("@Value======username======" + username);
        log.info("Environment======username======" + environment.getProperty("username"));
        log.info("@Value======redispass======" + redispass);
        log.info("Environment======redispass======" + environment.getProperty("redis.password"));

        log.info("@Value======username1======" + username1);
        log.info("Environment======username1======" + environment.getProperty("username1"));

        return userService.queryContent();
    }





}
