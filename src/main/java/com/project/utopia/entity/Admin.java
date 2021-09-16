package com.project.utopia.entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Admin {
    @Id
    private
    @OneToMany
    List<Announcement> announcements;
    
}
