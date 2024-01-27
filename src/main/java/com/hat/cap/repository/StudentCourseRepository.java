package com.hat.cap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hat.cap.entityDatabase.Course;
import com.hat.cap.entityDatabase.Student;
import com.hat.cap.entityDatabase.StudentCourse;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, Long> {
    int countByCourse(Course course);

    List<StudentCourse> findStudentCoursesByStudent(Student student);

    StudentCourse findStudentCourseByStudentAndCourse(Student student, Course course);

    @Transactional
    void deleteByStudentAndCourse(Student student, Course course);

}

