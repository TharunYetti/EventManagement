package com.tremendoustrio.EventManagement.controller;

import com.tremendoustrio.EventManagement.entity.RegistrationCard;
import com.tremendoustrio.EventManagement.entity.ReviewCard;
import com.tremendoustrio.EventManagement.entity.Volunteer;
import com.tremendoustrio.EventManagement.service.EventOrganizerService;
import com.tremendoustrio.EventManagement.service.RegistrationService;
import com.tremendoustrio.EventManagement.service.ReviewService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private EventOrganizerService eventOrganizerService;

    @GetMapping("/")
    public ModelAndView output(){
        return new ModelAndView("redirect:/index.html");
    }

    @GetMapping("/stdin")
    public ModelAndView output1(HttpSession session){
        return new ModelAndView("redirect:/student/student_home/index.html");
    }

    @GetMapping("/fltin")
    public ModelAndView output2(HttpSession session){
        return new ModelAndView("redirect:/faculty/faculty_home/index.html");
    }

    @GetMapping("/orgin")
    public ModelAndView output3(HttpSession session){
        return new ModelAndView("redirect:/eventOrganizer/organizer_home/index.html");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session){
        session.invalidate();
        return new ModelAndView("redirect:/index.html");
    }

    @GetMapping("/volunteers")
    public String volunteers(Model model){
        List<Volunteer> volunteerLists = eventOrganizerService.getAllVolunteers();
        model.addAttribute("volunteers", volunteerLists);
        System.out.println(volunteerLists);
        return "volunteers";
    }
}
