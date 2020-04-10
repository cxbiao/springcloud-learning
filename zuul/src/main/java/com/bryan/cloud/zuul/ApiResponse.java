package com.bryan.cloud.zuul;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private T data;
    private int code;
    private String message;
}
