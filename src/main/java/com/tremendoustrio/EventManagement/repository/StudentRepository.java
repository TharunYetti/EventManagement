package com.tremendoustrio.EventManagement.repository;

import com.tremendoustrio.EventManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByUsername(String username);
    @Query("SELECT s.email FROM Student s WHERE s.username = :username")
    String getEmailByUsername(@Param("username") String username);

}
