package com.tremendoustrio.EventManagement.repository;

import com.tremendoustrio.EventManagement.entity.EventCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventCard, Long> {

    @Query("SELECT e FROM EventCard e WHERE e.date = :eventDate")
    List<EventCard> findUpcomingEvents(@Param("eventDate") String eventDate);

}
