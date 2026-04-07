package com.example.Registration.TaskManager.dto;

public class LoginRequest {
    private String userEmail;
    private String password;

    public String getPassword() {

        return password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
