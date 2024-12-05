package com.tremendoustrio.EventManagement.service;

import com.tremendoustrio.EventManagement.entity.EventCard;
import com.tremendoustrio.EventManagement.entity.Organizer;
import com.tremendoustrio.EventManagement.entity.Volunteer;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface EventOrganizerService {
    String addOrganizer(Organizer organizer);
    boolean check(String username, String password, HttpSession session);

    String addEvent(EventCard eventCard);
    List<EventCard> getAllEvents();
    List<Volunteer> getAllVolunteers();
    void deleteVolunteer(String id);

}
