package com.tremendoustrio.EventManagement.repository;

import com.tremendoustrio.EventManagement.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    Organizer findByUsername(String username);
}
