package com.tremendoustrio.EventManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "event_card")
public class EventCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Or use another strategy as needed
    private Long id;
    @Column(name = "event")
    private String eventName;
    @Column(name = "date")
    private String date;
    @Column(name = "venue")
    private String venue;
}
