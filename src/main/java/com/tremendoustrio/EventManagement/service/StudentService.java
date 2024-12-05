package com.tremendoustrio.EventManagement.service;

import com.tremendoustrio.EventManagement.entity.Student;
import com.tremendoustrio.EventManagement.model.StudentRequest;
import jakarta.servlet.http.HttpSession;

public interface StudentService {
    String addStudent(StudentRequest s);
    boolean checkStudent(String username, String password, HttpSession session);
}
