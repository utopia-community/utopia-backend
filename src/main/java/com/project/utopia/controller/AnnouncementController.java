package com.project.utopia.controller;
import com.project.utopia.entity.Announcement;
import com.project.utopia.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @RequestMapping(value = "/announcements", method = RequestMethod.GET)
    public List<Announcement> getAnnouncements() {
        return announcementService.getAllAnnouncements();
    }
}
