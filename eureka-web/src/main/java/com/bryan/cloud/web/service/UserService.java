package com.bryan.cloud.web.service;

import java.util.List;
import java.util.concurrent.Future;

public interface UserService {
    List<String> queryContents();

    Future<String> queryContentsAsyn();

    List<String> queryContent();

    String queryMonitor();

}
