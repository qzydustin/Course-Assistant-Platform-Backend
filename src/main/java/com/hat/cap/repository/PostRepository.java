package com.hat.cap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hat.cap.entityDatabase.Course;
import com.hat.cap.entityDatabase.Post;

@Repository

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findPostsByCourse(Course course);

    Post findPostById(Long id);
}
