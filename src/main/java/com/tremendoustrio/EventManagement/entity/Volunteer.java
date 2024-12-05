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
public class Volunteer {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private long phone;
    @Column(name = "email")
    private String email;
}
