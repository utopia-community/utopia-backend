package com.project.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "announcements")
public class Announcement {
    private static final long serialVersionUID = 107L;

    @Id
    private int annoucementId;

    private String title;

    @ManyToOne
    Admin admin;


}
