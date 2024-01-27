package com.hat.cap.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hat.cap.entityDatabase.Student;

@Repository

public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findStudentByEmail(String email);

    Student findStudentByEmailAndPassword(String email, String password);

    @Transactional
    @Modifying
    @Query("update Student student set student.username = ?1 where student.id = ?2")
    void updateUsernameById(String username, Long id);

    @Transactional
    @Modifying
    @Query("update Student student set student.password = ?1 where student.id = ?2")
    void updatePasswordById(String password, Long id);


}
