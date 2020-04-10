package com.bryan.cloud.web.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * feign日志配置
 * 在构建@FeignClient注解修饰的服务客户端时，会为一个客户端都创建一个feign.Logger实例，
 * 可以利用日志来分析Feign的请求细节，不过默认	Feign的日志是不开启的
 */
//@Configuration
public class FeignClientConfig {

    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return feign.Logger.Level.FULL ;
    }

    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("bryan", "123456");
    }

}
