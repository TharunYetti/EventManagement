package com.tremendoustrio.EventManagement.controller;

import com.tremendoustrio.EventManagement.entity.RegistrationCard;
import com.tremendoustrio.EventManagement.entity.ReviewCard;
import com.tremendoustrio.EventManagement.entity.Volunteer;
import com.tremendoustrio.EventManagement.model.StudentRequest;
import com.tremendoustrio.EventManagement.service.RegistrationService;
import com.tremendoustrio.EventManagement.service.ReviewService;
import com.tremendoustrio.EventManagement.service.StudentService;
import com.tremendoustrio.EventManagement.service.VolunteerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/student")
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private ReviewService reviewService;

//    @GetMapping("/index.html")
//    public ModelAndView open(){
//        return new ModelAndView("redirect:/student/index.html");
//    }

    @PostMapping("/add")
    public String addStudent(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("name") String name,
                            @RequestParam("year") int year,
                            @RequestParam("phone") long phone,
                            @RequestParam("email") String email, HttpSession session){

        StudentRequest studentRequest = StudentRequest.builder()
                .email(email)
                .name(name)
                .password(password)
                .phone(phone)
                .username(username)
                .year(year)
                .build();

        studentService.addStudent(studentRequest);
        session.setAttribute("username",username);
        session.setAttribute("name",name);
        session.setAttribute("year",year);
        session.setAttribute("phone",phone);
        session.setAttribute("email",email);
        return "redirect:/stdin";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttributes){

        boolean status = studentService.checkStudent(username,password, session);
        if(status){
//            boolean result = volunteerService.check(session);
//            model.addAttribute("volunteerStatus",result);
//            System.out.println(result);
            List<ReviewCard> reviews = reviewService.getAll();
            session.setAttribute("reviews",reviews);
//            redirectAttributes.addFlashAttribute("reviews",reviews);
            System.out.println(reviews);

            return "redirect:/student/student_home/index.html";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/student_home/volunteer")
    public String registerVolunteer(HttpSession session, Model model){
        System.out.println((String) session.getAttribute("username"));
//        System.out.println((String) session.getAttribute("name"));
        System.out.println((Long) session.getAttribute("phone"));
        System.out.println((String) session.getAttribute("email"));
        Volunteer volunteer = Volunteer.builder()
                .id((String) session.getAttribute("username"))
                .name((String) session.getAttribute("name"))
                .phone((Long) session.getAttribute("phone"))
                .email((String) session.getAttribute("email"))
                .build();
        volunteerService.addVolunteer(volunteer);

        boolean result = volunteerService.check(session);
        System.out.println(result);
        model.addAttribute("volunteerStatus",result);

        return "redirect:/student/student_home/index.html";
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

        return "redirect:/student/student_home/index.html";
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

        return "redirect:/student/student_home/index.html";
    }

}
