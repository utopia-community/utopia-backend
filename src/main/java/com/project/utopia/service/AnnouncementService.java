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
        long now = System.currentTimeMillis();
        announcementObject.setCreationTime(now);
        announcementDao.saveAnnouncement(announcementObject);
    }

    public Announcement getAnnouncementById(int announcementId) {
        return announcementDao.getAnnouncementById(announcementId);
    }

    public List<Announcement> getAllAnnouncements() {
        List<Announcement> announcements = announcementDao.getAllAnnouncements();
        announcements.sort((o1, o2) -> Long.compare(o2.getCreationTime(), o1.getCreationTime()));
        // return the top 6 latest announcements
        if (announcements.size() > 6) {
            List<Announcement> result = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                result.add(announcements.get(i));
            }
            return result;
        }
        return announcements;
    }
}
