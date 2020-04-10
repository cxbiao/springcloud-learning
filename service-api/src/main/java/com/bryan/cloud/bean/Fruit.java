package com.bryan.cloud.bean;


import lombok.Data;

import java.io.Serializable;

@Data
public class Fruit implements Serializable {
    private Integer id;
    private String name;
    private double money;
}
