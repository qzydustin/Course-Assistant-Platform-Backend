package com.hat.cap.service;

import com.hat.cap.entityDatabase.Course;
import com.hat.cap.entityDatabase.Student;
import com.hat.cap.entityDatabase.StudentCourse;
import com.hat.cap.repository.CourseRepository;
import com.hat.cap.repository.InstructorRepository;
import com.hat.cap.repository.StudentCourseRepository;
import com.hat.cap.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PermissionService {
    @Resource
    private InstructorRepository instructorRepository;
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private CourseRepository courseRepository;
    @Resource
    private StudentCourseRepository studentCourseRepository;

    public Boolean hasPermission(String type, String email, String password) {
        Object user = null;
        if (type.equals("student")) {
            user = studentRepository.findStudentByEmailAndPassword(email, password);
        } else if (type.equals("instructor")) {
            user = instructorRepository.findInstructorByEmailAndPassword(email, password);
        }
        return user != null;
    }

    public boolean hasCoursePermission(String type, String email, String password, Long courseID) {
        Object user = null;
        if (type.equals("student")) {
            user = studentRepository.findStudentByEmailAndPassword(email, password);

        } else if (type.equals("instructor")) {
            user = instructorRepository.findInstructorByEmailAndPassword(email, password);
        }
        if (user == null) {
            return false;
        }
        Course course = courseRepository.findCourseById(courseID);
        if (course == null) {
            return false;
        }
        if (type.equals("student")) {
            StudentCourse studentCourse = studentCourseRepository.findStudentCourseByStudentAndCourse((Student) user, course);
            return studentCourse != null;
        } else {
            return course.getInstructor() == user;
        }
    }
}
