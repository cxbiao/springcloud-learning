package com.bryan.cloud.web.service.feign;

import com.bryan.cloud.api.TeacherService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "micro-order",contextId = "m2")
public interface TeacherServiceFeign extends TeacherService {
}
