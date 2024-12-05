package com.tremendoustrio.EventManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewCard {
    @Id
    private String username;
    @Column(name = "event")
    private String event;
    @Column(name = "message")
    private String message;
}
