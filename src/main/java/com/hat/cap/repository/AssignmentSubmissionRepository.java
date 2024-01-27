package com.hat.cap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hat.cap.entityDatabase.Assignment;
import com.hat.cap.entityDatabase.AssignmentSubmission;

@Repository
public interface AssignmentSubmissionRepository extends CrudRepository<AssignmentSubmission, Long> {
    List<AssignmentSubmission> findAssignmentSubmissionsByAssignment(Assignment assignment);

    AssignmentSubmission findAssignmentSubmissionById(Long id);

    @Transactional
    @Modifying
    @Query("update AssignmentSubmission submission set submission.score = ?1 where submission.id = ?2")
    void updateScoreById(Double score, Long id);
}
