package com.bryan.cloud.service.impl;

import com.bryan.cloud.service.UserService;
import com.bryan.cloud.utils.DataCenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<String> queryContent() {
        return DataCenter.makeContent();
    }


}
