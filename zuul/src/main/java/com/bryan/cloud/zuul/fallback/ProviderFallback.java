package com.bryan.cloud.zuul.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * zuul熔断
 * getRoute：方法可以返回服务的ID，比如‘microcloud-provider-product’，如果需要匹配全部适应 “*”
 */
//@Configuration
@Slf4j
public class ProviderFallback implements FallbackProvider{
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        String message = cause.getCause().getMessage();
        String localizedMessage = cause.getLocalizedMessage();

        cause.printStackTrace();
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.BAD_REQUEST.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("产品微服务不可用，请稍后再试。".getBytes());

            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders() ;
                headers.set("Content-Type", "text/html; charset=UTF-8");
                return headers;

            }
        };
    }
}
