package com.project.utopia.service;

import com.project.utopia.dao.AnnouncementDao;
import com.project.utopia.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementDao announcementDao;

    public List<Announcement> getAllAnnouncements() {
        return null;
     //   return announcementDao.getAllAnnouncements();
    }
}
