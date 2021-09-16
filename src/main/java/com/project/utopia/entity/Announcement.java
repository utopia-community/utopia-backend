package com.project.utopia.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "announcements")
public class Announcement implements Serializable {
    @Id
    @Column(name = "announcement_id")
    private int announcementId;

    private String title;

    private String Content; // string type?

    @ManyToOne
    private User user;

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
