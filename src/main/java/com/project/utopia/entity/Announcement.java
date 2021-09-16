package com.project.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "announcements")
public class Announcement implements Serializable {

    private static final long serialVersionUID = 107L;
    @Id
    private int annoucementId;

    private String title;
    private String content;
    private int dateCreated;

    @ManyToOne
    private Admin admin;


}
