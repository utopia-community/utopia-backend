package com.project.utopia.dao;

import com.project.utopia.entity.Announcement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnnouncementDao {
    @Autowired
    SessionFactory sessionFactory;

    public void save(Announcement announcement) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(announcement);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void saveAnnouncement(Announcement announcement) {

    }

    public Announcement getAnnouncementById(int announcementId) {
        return null;
    }

    public List<Announcement> getAllAnnouncements() {
        return null;
    }

}
