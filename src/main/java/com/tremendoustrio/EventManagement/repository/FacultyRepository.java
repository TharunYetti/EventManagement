package com.tremendoustrio.EventManagement.repository;

import com.tremendoustrio.EventManagement.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    Faculty findByUsername(String username);
}
