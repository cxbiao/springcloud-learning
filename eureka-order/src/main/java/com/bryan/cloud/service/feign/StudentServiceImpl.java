package com.bryan.cloud.service.feign;


import com.bryan.cloud.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public String getAllStudent() {
        return "getAllStudent";
    }

    @Override
    public String saveStudent(Student student) {
        return "saveStudent";
    }

    @Override
    public String queryStudentById(Integer id) {
        return "queryStudentById";
    }

    @Override
    public String errorMessage(Integer id) {
        try {
            int a = 1 / 0;
            return "errorMessage";
        }catch (Exception e) {
            e.printStackTrace();
//            return e.getMessage();
            throw e;
        }
    }

    @Override
    public String queryStudentTimeout(int millis) {
        return null;
    }
}
