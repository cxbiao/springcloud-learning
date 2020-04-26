package com.bryan.cloud.api;

import com.bryan.cloud.bean.ApiResponse;
import com.bryan.cloud.bean.Teacher;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/feign/teacher")
public interface TeacherService {
    @GetMapping("/getAllTeacher")
    String getAllTeacher();

    @PostMapping("/saveTeacher")
    ApiResponse saveTeacher(@RequestBody Teacher Teacher);

    @GetMapping("/getTeacherById")
    String getTeacherById(@RequestParam("id") Integer id);

    @GetMapping("/getTeacherByName/{name}")
    String getTeacherByName(@PathVariable("name") String name);

    @GetMapping("/errorMessage")
    String errorMessage(@RequestParam("id") Integer id);
}
