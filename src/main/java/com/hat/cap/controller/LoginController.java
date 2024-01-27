package com.hat.cap.controller;

import com.hat.cap.entityDatabase.Instructor;
import com.hat.cap.entityDatabase.Student;
import com.hat.cap.entityResult.Result;
import com.hat.cap.entityResult.ResultUser;
import com.hat.cap.service.InstructorService;
import com.hat.cap.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

import static com.hat.cap.entityResult.Code.*;

@RestController
public class LoginController {
    @Resource
    private StudentService studentService;
    @Resource
    private InstructorService instructorService;


    @PostMapping("/login")
    public Result<?> login(@RequestBody Map<String, String> map) {
        String type = map.get("type");
        String email = map.get("email").toLowerCase();
        String password = map.get("password");

        if (type.equals("student")) {
            Student student = studentService.getStudent(email, password);
            if (student==null){
                return new Result<>(LOGIN_FAIL);
            }
            return new Result<>(SUCCESS, new ResultUser(student));
        } else if (type.equals("instructor")) {
            Instructor instructor = instructorService.getInstructor(email, password);
            if (instructor==null){
                return new Result<>(LOGIN_FAIL);
            }
            return new Result<>(SUCCESS, new ResultUser(instructor));
        } else {
            return new Result<>(NO_PERMISSION);
        }
    }
}
