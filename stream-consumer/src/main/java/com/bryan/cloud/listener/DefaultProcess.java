package com.bryan.cloud.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface DefaultProcess {
    String INPUT = "bryan_input"; // 输入通道名称
    @Input(DefaultProcess.INPUT)
    public SubscribableChannel input();


}
