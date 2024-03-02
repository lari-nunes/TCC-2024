package com.larissa.tcc2024.model;

import java.util.UUID;

public class LoginResponse {
    private String id;

    public LoginResponse(UUID id) {
        this.id = String.valueOf(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
