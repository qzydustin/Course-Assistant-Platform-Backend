package com.hat.cap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hat.cap.entityDatabase.Course;
import com.hat.cap.entityDatabase.Instructor;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findCoursesByDepartmentAndSemester(String department, String Semester);

    Course findCourseByCodeAndSemester(String code, String Semester);

    List<Course> findCoursesByInstructor(Instructor instructor);

    Course findCourseById(Long id);
}
