package com.bryan.cloud.zuul.controller;

import com.bryan.cloud.zuul.ApiResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ExceptionController implements ErrorController {

    /**
     * zuul的异常处理  ProviderFallback这个也可以
     *
     * @param request HTTP请求
     * @return API统一响应
     */
    @RequestMapping("/error")
    public ApiResponse error(HttpServletRequest request, HttpServletResponse response) {
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        String message = (String) request.getAttribute("javax.servlet.error.message");


        if (StringUtils.isEmpty(message)) {
            message = "微服务不可用，请稍后重试";
        }

        response.setStatus(HttpStatus.OK.value());

        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setCode(code);
        apiResponse.setMessage(message);
        return apiResponse;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
