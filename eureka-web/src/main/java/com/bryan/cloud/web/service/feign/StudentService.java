package com.bryan.cloud.web.service.feign;

import com.bryan.cloud.web.pojo.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/*
* fallback = StudentServiceFallback.class  不能获取具体异常
* fallbackFactory 可以得到具体异常
*  对象类型参数  @RequestBody(经测试可以不加)
*   其他参数 @RequestParam @PathVariable
* */
@FeignClient(name = "micro-order",contextId = "m1",path = "/feign"
        /*fallback = StudentServiceFallback.class,*/
        ,fallbackFactory = StudentServiceFallbackFactory.class)
public interface StudentService {

    @GetMapping("/student/getAllStudent")
    String getAllStudent();

    @PostMapping("/student/saveStudent")
    String saveStudent(@RequestBody Student student);


    @GetMapping("/student/getStudentById")
    String getStudentById(@RequestParam Integer id);

    @GetMapping("/student/errorMessage")
    String errorMessage(@RequestParam("id") Integer id);

    @GetMapping("/student/queryStudentTimeout")
    String queryStudentTimeout(@RequestParam("millis") int millis);
}
