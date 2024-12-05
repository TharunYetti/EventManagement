package com.tremendoustrio.EventManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventCardTo {
    private String title;
    private String start;
    private String venue;
}