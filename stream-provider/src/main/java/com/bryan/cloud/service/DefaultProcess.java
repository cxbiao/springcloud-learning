package com.bryan.cloud.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface DefaultProcess {

    String OUTPUT = "bryan_output"; // 输出通道名称
    @Output(DefaultProcess.OUTPUT)
    MessageChannel output();

}
