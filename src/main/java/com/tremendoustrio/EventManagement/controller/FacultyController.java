package com.tremendoustrio.EventManagement.controller;

import com.tremendoustrio.EventManagement.entity.Faculty;
import com.tremendoustrio.EventManagement.entity.RegistrationCard;
import com.tremendoustrio.EventManagement.entity.ReviewCard;
import com.tremendoustrio.EventManagement.service.FacultyService;
import com.tremendoustrio.EventManagement.service.RegistrationService;
import com.tremendoustrio.EventManagement.service.ReviewService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/faculty")
@Controller
public class FacultyController {

    @Autowired
    private FacultyService facultyService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public String addFaculty(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("name") String name,
                             @RequestParam("phone") long phone,
                             @RequestParam("email") String email, HttpSession session){

        Faculty faculty = Faculty.builder()
                .username(username)
                .password(password)
                .name(name)
                .phone(phone)
                .email(email)
                .build();

        facultyService.add(faculty);
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        session.setAttribute("name",name);
        session.setAttribute("phone",phone);
        session.setAttribute("email",email);

        return "redirect:/fltin";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, HttpSession session){

        boolean status = facultyService.check(username,password, session);
        if(status){
            return "redirect:/faculty/faculty_home/index.html";
        }
        else{
            return "redirect:/";
        }
    }

    @PostMapping("/register")
    public String registerEvent(@RequestParam("username") String username,
                                @RequestParam("name") String name,
                                @RequestParam("date") String date,
                                @RequestParam("dropdown") String event){

        RegistrationCard registrationCard = RegistrationCard.builder()
                .username(username)
                .name(name)
                .date(date)
                .event(event)
                .build();

        registrationService.addCard(registrationCard);

        return "redirect:/faculty/faculty_home/index.html";
    }

    @PostMapping("/review")
    public String reviewUs(@RequestParam("username") String username,
                           @RequestParam("dropdown") String event,
                           @RequestParam("review") String message){

        ReviewCard reviewCard = ReviewCard.builder()
                .username(username)
                .event(event)
                .message(message)
                .build();

        reviewService.addReview(reviewCard);

        return "redirect:/faculty/faculty_home/index.html";
    }

}
