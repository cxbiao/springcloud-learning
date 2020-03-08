package com.bryan.cloud.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataCenter {

    private static String[] contents={"电脑","台灯","空调","床上用品","学习文具","报纸","水杯","玻璃","门锁","水龙头"};

    public static List<String> makeContent(){
        List<String> ret=new ArrayList<>();
        Random random=new Random();
        for(int i=0;i<5;i++){
            String select=contents[random.nextInt(10)];
            if(!ret.contains(select)){
                ret.add(select);
            }
        }
        return ret;

    }
}
