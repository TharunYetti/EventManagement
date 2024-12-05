package com.tremendoustrio.EventManagement.service;

import com.tremendoustrio.EventManagement.entity.Faculty;
import jakarta.servlet.http.HttpSession;

public interface FacultyService {
    void add(Faculty faculty);
    boolean check(String username, String password, HttpSession session);
}
