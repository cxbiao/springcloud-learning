package com.bryan.cloud.web.service.feign;

import com.bryan.cloud.api.TeacherService;
import com.bryan.cloud.bean.ApiResponse;
import com.bryan.cloud.bean.Teacher;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TeacherServiceFallbackFactory implements FallbackFactory<TeacherService> {
    @Override
    public TeacherService create(Throwable throwable) {
        if(throwable == null) {
            return null;
        }
        final String msg = throwable.getMessage();
        log.info("exception:" + msg);
        return new TeacherService() {
            @Override
            public String getAllTeacher() {
                return "getAllTeacher error";
            }

            @Override
            public ApiResponse saveTeacher(Teacher Teacher) {
                return ApiResponse.builder().code(-1).message("error").build();
               // return null;
            }

            @Override
            public String getTeacherById(Integer id) {
                return "getTeacherById error";
            }

            @Override
            public String getTeacherByName(String name) {
                return "getTeacherByName error";
            }

            @Override
            public String errorMessage(Integer id) {
                return "errorMessage error";
            }
        };
    }
}
