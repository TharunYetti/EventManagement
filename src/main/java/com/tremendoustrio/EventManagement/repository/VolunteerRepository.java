package com.tremendoustrio.EventManagement.repository;

import com.tremendoustrio.EventManagement.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
     Volunteer findById(String id);
}
