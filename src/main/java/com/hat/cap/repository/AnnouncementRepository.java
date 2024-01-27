package com.hat.cap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hat.cap.entityDatabase.Announcement;
import com.hat.cap.entityDatabase.Course;

@Repository
public interface AnnouncementRepository extends CrudRepository<Announcement, Long> {
    List<Announcement> findAnnouncementsByCourse(Course course);

}
