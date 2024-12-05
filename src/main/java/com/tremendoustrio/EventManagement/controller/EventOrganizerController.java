package com.tremendoustrio.EventManagement.controller;

import com.tremendoustrio.EventManagement.entity.EventCard;
import com.tremendoustrio.EventManagement.entity.Organizer;
import com.tremendoustrio.EventManagement.service.EventOrganizerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/eventOrganizer")
@Controller
public class EventOrganizerController {

    @Autowired
    private EventOrganizerService eventOrganizerService;

    @PostMapping("/add")
    public String addStudent(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("name") String name,
                             @RequestParam("phone") long phone,
                             @RequestParam("email") String email, HttpSession session){

        Organizer organizer = Organizer.builder()
                .username(username)
                .password(password)
                .name(name)
                .phone(phone)
                .email(email)
                .build();

        eventOrganizerService.addOrganizer(organizer);
        session.setAttribute("username",username);
        session.setAttribute("name",name);
        session.setAttribute("phone",phone);
        session.setAttribute("email",email);
        return "redirect:/orgin";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, HttpSession session){

        boolean status = eventOrganizerService.check(username,password, session);
        if(status){
            return "redirect:/eventOrganizer/organizer_home/index.html";
        }
        else{
            return "redirect:/";
        }
    }

    @PostMapping("/addEvent")
    public String registerEvent(@RequestParam("event") String event,
                                @RequestParam("date") String date,
                                @RequestParam("venue") String venue){

        EventCard eventCard = EventCard.builder()
                .eventName(event)
                .date(date)
                .venue(venue)
                .build();

        eventOrganizerService.addEvent(eventCard);

        return "redirect:/eventOrganizer/organizer_home/index.html";
    }
    @GetMapping("/organizer_home/displayEvents")
    public String events(Model model){
        List<EventCard> events = eventOrganizerService.getAllEvents();
        model.addAttribute("events", events);
        System.out.println(events);
        return "events";
    }
//    @GetMapping("/organizer_home/displayVolunteers")
//    public String volunteers(Model model){
//        List<Volunteer> volunteerLists = eventOrganizerService.getAllVolunteers();
//        model.addAttribute("volunteers", volunteerLists);
//        System.out.println(volunteerLists);
//        return "volunteers";
//    }

    @PostMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable("id") String id) {
        eventOrganizerService.deleteVolunteer(id);
        return "redirect:/volunteers"; // Redirect to the events page after deletion
    }
}