package com.hat.cap.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hat.cap.entityDatabase.Instructor;

@Repository

public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    Instructor findInstructorByEmail(String email);

    Instructor findInstructorByEmailAndPassword(String email, String password);

    @Transactional
    @Modifying
    @Query("update Instructor instructor set instructor.username = ?1 where instructor.id = ?2")
    void updateUsernameById(String username, Long id);

    @Transactional
    @Modifying
    @Query("update Instructor instructor set instructor.password = ?1 where instructor.id = ?2")
    void updatePasswordById(String password, Long id);
}
