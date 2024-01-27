package com.hat.cap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hat.cap.entityDatabase.Post;
import com.hat.cap.entityDatabase.PostComment;

@Repository

public interface PostCommentRepository extends CrudRepository<PostComment, Long> {
    List<PostComment> findPostCommentsByPost(Post post);
}
