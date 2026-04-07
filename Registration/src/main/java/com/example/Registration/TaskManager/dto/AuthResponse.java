package com.example.Registration.TaskManager.dto;

public class AuthResponse {
    private String token;
    private String email;
    private String role;
public AuthResponse(String token, String email, String role){
    this.token=token;
    this.email=email;
    this.role=role;
}
    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public String getRole() {
        return role;
    }
}
