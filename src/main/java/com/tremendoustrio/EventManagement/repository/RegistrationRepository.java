package com.tremendoustrio.EventManagement.repository;

import com.tremendoustrio.EventManagement.entity.RegistrationCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationCard,Long> {

    @Query("SELECT u FROM RegistrationCard u WHERE u.event = :eventName")
    List<RegistrationCard> findAttendeesByEventName(String eventName);

}
