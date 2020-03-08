package com.bryan.cloud.web.controller;

import com.bryan.cloud.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/printInfo")
    public List<String> printInfo(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if(cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                log.info("cookie name = >" + cookies[i].getName() + "= >" + "cookie value = " + cookies[i].getValue());
            }
        }

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headername = headerNames.nextElement();
            log.info("header name = >" + headername + "= >" + "headervalue = " + request.getHeader(headername));
        }

        return userService.queryContents();
    }

    @RequestMapping("/queryUser")
    public List<String> queryUser(HttpServletRequest request) {
        request.getCookies();
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headername = headerNames.nextElement();
            log.info("header name = >" + headername + "= >" + "headervalue = " + request.getHeader(headername));
        }
        return userService.queryContents();
    }

    @RequestMapping("/queryContent")
    public List<String> queryContent() {
        log.info(Thread.currentThread().getName());
        return userService.queryContent();
    }

    @RequestMapping("/queryContentsAsync")
    public String queryContentsAsync() {
        Future<String> stringFuture = userService.queryContentsAsyn();
        try {
            String cacheResult = stringFuture.get();

            return cacheResult;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/queryMonitor")
    public String queryMonitor() {
        return userService.queryMonitor();
    }


}
