package com.tremendoustrio.EventManagement.model;

import java.util.UUID;

public class SessionUntil {
    public static String generateUniqueSessionId() {
        return UUID.randomUUID().toString();
    }
}
