package com.project.utopia.service;

import com.project.utopia.dao.AnnouncementDao;
import com.project.utopia.entity.Announcement;
import com.project.utopia.entity.Customer;
import com.project.utopia.entity.Request;
import com.project.utopia.holder.request.AnnouncementRequestBody;
import com.project.utopia.holder.request.NewRequestRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementDao announcementDao;

    public void saveAnnouncement(Announcement announcement){
        announcementDao.save(announcement);
    }


    public List<Announcement> getAllAnnouncements() {
        return null;
     //   return announcementDao.getAllAnnouncements();
    }
}
