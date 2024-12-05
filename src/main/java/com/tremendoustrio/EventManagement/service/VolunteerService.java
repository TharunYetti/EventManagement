package com.tremendoustrio.EventManagement.service;

import com.tremendoustrio.EventManagement.entity.Volunteer;
import com.tremendoustrio.EventManagement.model.StudentRequest;
import jakarta.servlet.http.HttpSession;

public interface VolunteerService {
    void addVolunteer(Volunteer volunteer);
    boolean check(HttpSession session);

}
