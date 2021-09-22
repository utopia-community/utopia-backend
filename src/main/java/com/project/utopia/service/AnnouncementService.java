package com.project.utopia.service;


import com.project.utopia.dao.AnnouncementDao;
import com.project.utopia.entity.Announcement;
import com.project.utopia.holder.request.AnnouncementRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementDao announcementDao;

    public void saveAnnouncement(AnnouncementRequestBody requestBody){
        Announcement announcementObject = new Announcement();
        announcementObject.setTitle(requestBody.getTitle());
        announcementObject.setCategory(requestBody.getCategory());
        announcementObject.setContent(requestBody.getContent());
        //Date  date = new current Date
        long time = System.currentTimeMillis();
        announcementObject.setCreationTime("11");
        //change time into a string : 03/10/2021 19:38
        announcementDao.saveAnnouncement(announcementObject);
    }

    public Announcement getAnnouncementById(int announcementId) {
        return announcementDao.getAnnouncementById(announcementId);
    }

    public List<Announcement> getAllAnnouncements() {
        List<Announcement> announcements = announcementDao.getAllAnnouncements();
        // return the top 6 latest announcements
        if (announcements.size() > 6) {
            return announcements.subList(0, 6);
        }
        return announcements;
    }
}
