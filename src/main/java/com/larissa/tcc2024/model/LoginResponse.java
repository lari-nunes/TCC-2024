package com.larissa.tcc2024.model;

import java.util.UUID;

public class LoginResponse {
    private UUID id;

    public LoginResponse(UUID id) {
        this.id = id;
    }

    // Getter
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
