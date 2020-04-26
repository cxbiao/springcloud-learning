package com.bryan.cloud.controller;


import com.bryan.cloud.api.TeacherService;
import com.bryan.cloud.bean.ApiResponse;
import com.bryan.cloud.bean.Teacher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController implements TeacherService {
    @Override
    public String getAllTeacher() {
        return "micro-order.getAllTeacher";
    }

    @Override
    public ApiResponse saveTeacher(@RequestBody Teacher Teacher) {
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setCode(0);
        apiResponse.setMessage("success");
        int i=1/0;
        return apiResponse;
//        return "micro-order.saveTeacher";
    }

    @Override
    public String getTeacherById(@RequestParam("id") Integer id) {
        return "micro-order.getTeacherById";
    }

    @Override
    public String getTeacherByName(@PathVariable("name") String name) {
        return "micro-order.getTeacherByName";
    }

    @Override
    public String errorMessage(@RequestParam("id") Integer id) {
        return "micro-order.errorMessage";
    }
}
