package com.tremendoustrio.EventManagement.service;

import com.tremendoustrio.EventManagement.entity.Volunteer;
import com.tremendoustrio.EventManagement.model.StudentRequest;
import com.tremendoustrio.EventManagement.repository.VolunteerRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerServiceImpl implements VolunteerService{

    @Autowired
    private VolunteerRepository volunteerRepository;

    @Override
    public void addVolunteer(Volunteer volunteer) {
        volunteerRepository.save(volunteer);
    }

    @Override
    public boolean check(HttpSession session) {

        Volunteer volunteer = volunteerRepository.findById((String) session.getAttribute("username"));
        if(volunteer == null) return false;
        return true;
    }
}
