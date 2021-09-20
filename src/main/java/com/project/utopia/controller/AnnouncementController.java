package com.project.utopia.controller;
import com.project.utopia.entity.Announcement;
import com.project.utopia.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementService;

    @RequestMapping(value = "/newAnnouncement", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void submitRequest(@RequestBody Announcement announcement) {
        announcementService.saveAnnouncement(announcement);
    }



}
