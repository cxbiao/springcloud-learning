package com.bryan.cloud.service.feign;


import com.bryan.cloud.pojo.Student;

public interface StudentService {

    String getAllStudent();

    String saveStudent(Student student);

    String queryStudentById(Integer id);

    String errorMessage(Integer id);

    String queryStudentTimeout(int millis);
}
