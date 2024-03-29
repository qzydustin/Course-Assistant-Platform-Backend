package com.hat.cap.service;

import com.hat.cap.entityDatabase.Announcement;
import com.hat.cap.entityDatabase.Course;
import com.hat.cap.entityResult.ResultAnnouncement;
import com.hat.cap.repository.AnnouncementRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementService {
    @Resource
    private AnnouncementRepository announcementRepository;

    public List<ResultAnnouncement> getAnnouncements(Course course) {
        List<Announcement> announcements = announcementRepository.findAnnouncementsByCourse(course);
        ArrayList<ResultAnnouncement> resultAnnouncements = new ArrayList<>();
        for (Announcement announcement : announcements) {
            resultAnnouncements.add(new ResultAnnouncement((announcement)));
        }
        return resultAnnouncements;
    }

    public void createAnnouncement(Announcement announcement) {
        announcementRepository.save(announcement);
    }
}
