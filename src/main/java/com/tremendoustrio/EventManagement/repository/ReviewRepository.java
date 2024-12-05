package com.tremendoustrio.EventManagement.repository;

import com.tremendoustrio.EventManagement.entity.ReviewCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewCard, Long> {
}
