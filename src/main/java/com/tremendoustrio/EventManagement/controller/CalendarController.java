package com.tremendoustrio.EventManagement.controller;

import com.tremendoustrio.EventManagement.model.EventCardTo;
import com.tremendoustrio.EventManagement.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/events")
public class CalendarController {
    @Autowired
    private EventRepository eventCardRepository;

    @GetMapping
    public List<EventCardTo> getAllEvents() {
        return eventCardRepository.findAll().stream()
                .map(eventCard -> new EventCardTo(
                        eventCard.getEventName(),
                        eventCard.getDate(), // Default start time
                        eventCard.getVenue()// Default end time
                ))
                .collect(Collectors.toList());
    }
}
