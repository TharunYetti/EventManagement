package com.tremendoustrio.EventManagement.service;

import com.tremendoustrio.EventManagement.entity.RegistrationCard;
import com.tremendoustrio.EventManagement.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public String addCard(RegistrationCard registrationCard) {
        registrationRepository.save(registrationCard);
        return "";
    }
}
