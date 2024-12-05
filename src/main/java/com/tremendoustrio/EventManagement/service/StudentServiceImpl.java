package com.tremendoustrio.EventManagement.service;

import com.tremendoustrio.EventManagement.entity.Student;
import com.tremendoustrio.EventManagement.model.StudentRequest;
import com.tremendoustrio.EventManagement.repository.StudentRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String addStudent(StudentRequest s) {
        Student student =Student.builder().username(s.getUsername())
                .password(s.getPassword())
                .name(s.getName())
                .email(s.getEmail())
                .phone(s.getPhone())
                .year(s.getYear())
                .build();
        studentRepository.save(student);
        return "";
    }

    @Override
    public boolean checkStudent(String username, String password, HttpSession session) {
        Student student = studentRepository.findByUsername(username);
        if(student==null) return false;
        if(student.getPassword().equals(password)) {
            session.setAttribute("username",student.getUsername());
            session.setAttribute("phone",student.getPhone());
            session.setAttribute("year",student.getYear());
            session.setAttribute("name",student.getName());
            session.setAttribute("email",student.getEmail());

            System.out.println("Session attributes set:");
            System.out.println("Username: " + session.getAttribute("username"));
            System.out.println("Phone: " + session.getAttribute("phone"));
            System.out.println("Year: " + session.getAttribute("year"));
            System.out.println("Name: " + session.getAttribute("name"));
            System.out.println("Email: " + session.getAttribute("email"));

            return true;
        }
        return false;
    }
}
