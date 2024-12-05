package com.tremendoustrio.EventManagement.model;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentRequest {
    private String username;
    private String password;
    private String name;
    private int year;
    private long phone;
    private String email;
}
