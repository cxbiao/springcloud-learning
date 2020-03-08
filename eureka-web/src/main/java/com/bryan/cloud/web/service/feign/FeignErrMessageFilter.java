package com.bryan.cloud.web.service.feign;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;


@Configuration
public class FeignErrMessageFilter {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }

    /*
    * 当调用服务时，如果服务返回的状态码不是200，就会进入到Feign的ErrorDecoder中
    * {"timestamp":"2020-02-17T14:01:18.080+0000","status":500,"error":"Internal Server Error","message":"/ by zero","path":"/feign/student/errorMessage"}
    * 只有这种方式才能获取所有的被feign包装过的异常信息
    *
    * 这里如果创建的Exception是HystrixBadRequestException
    * 则不会走熔断逻辑，不记入熔断统计
    *
    *这个过滤器是对异常信息的再封装，把feign的异常信息封装成我们系统的通用异常对象
    * 过滤器把异常返回后，feign前面定义的降级方法就会调到create方法。
    * */
    class FeignErrorDecoder implements ErrorDecoder {

        private Logger logger = LoggerFactory.getLogger(FeignErrorDecoder.class);

        @Override
        public Exception decode(String s, Response response) {

            RuntimeException runtimeException = null;

            try {
                String retMsg = Util.toString(response.body().asReader());
                logger.info(retMsg);

                runtimeException = new RuntimeException(retMsg);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return runtimeException;
        }
    }
}
