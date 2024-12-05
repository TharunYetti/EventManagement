package com.tremendoustrio.EventManagement.service;

import com.tremendoustrio.EventManagement.entity.EventCard;
import com.tremendoustrio.EventManagement.entity.Organizer;
import com.tremendoustrio.EventManagement.entity.Volunteer;
import com.tremendoustrio.EventManagement.repository.EventRepository;
import com.tremendoustrio.EventManagement.repository.OrganizerRepository;
import com.tremendoustrio.EventManagement.repository.VolunteerRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventOrganizerServiceImpl implements EventOrganizerService{

    @Autowired
    private OrganizerRepository organizerRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private VolunteerRepository volunteerRepository;

    @Override
    public String addOrganizer(Organizer organizer) {
        organizerRepository.save(organizer);
        return "";
    }

    @Override
    public boolean check(String username, String password, HttpSession session) {
        Organizer organizer = organizerRepository.findByUsername(username);
        if(organizer==null) return false;
        if(organizer.getPassword().equals(password)) {
            session.setAttribute("username",organizer.getUsername());
            session.setAttribute("phone",organizer.getPhone());
            session.setAttribute("name",organizer.getName());
            session.setAttribute("email",organizer.getEmail());

            System.out.println("Session attributes set:");
            System.out.println("Username: " + session.getAttribute("username"));
            System.out.println("Phone: " + session.getAttribute("phone"));
            System.out.println("Name: " + session.getAttribute("name"));
            System.out.println("Email: " + session.getAttribute("email"));

            return true;
        }
        return false;
    }

    @Override
    public String addEvent(EventCard eventCard) {
        eventRepository.save(eventCard);
        return "";
    }

    @Override
    public List<EventCard> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    @Override
    public void deleteVolunteer(String id) {
        volunteerRepository.delete(volunteerRepository.findById(id));
    }
}
