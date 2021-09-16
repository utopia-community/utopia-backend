package com.project.utopia.dao;

import com.project.utopia.entity.Announcement;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnnouncementDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Announcement> getAllAnnouncements() {
        return null;
    }
}
