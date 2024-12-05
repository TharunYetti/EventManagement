package com.tremendoustrio.EventManagement.service;

import com.tremendoustrio.EventManagement.entity.Faculty;
import com.tremendoustrio.EventManagement.repository.FacultyRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public void add(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    @Override
    public boolean check(String username, String password, HttpSession session) {

        Faculty faculty = facultyRepository.findByUsername(username);
        if(faculty==null) return false;
        if(faculty.getPassword().equals(password)){

            session.setAttribute("username",faculty.getUsername());
            session.setAttribute("phone",faculty.getPhone());
            session.setAttribute("name",faculty.getName());
            session.setAttribute("email",faculty.getEmail());

            System.out.println("Session attributes set:");
            System.out.println("Username: " + session.getAttribute("username"));
            System.out.println("Phone: " + session.getAttribute("phone"));
            System.out.println("Name: " + session.getAttribute("name"));
            System.out.println("Email: " + session.getAttribute("email"));

            return true;
        }

        return false;
    }
}
