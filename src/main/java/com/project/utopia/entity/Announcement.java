package com.project.utopia.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "announcements")
public class Announcement implements Serializable {
    @Id
    @Column(name = "announcement_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int announcementId;

    private String title;

    private String Content; // string type?

    private String category;

    private long creationTime;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

}
