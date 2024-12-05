package com.tremendoustrio.EventManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "registration_card")
public class RegistrationCard {
    @Id
    private String username;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private String date;
    @Column(name = "event")
    private String event;
}
