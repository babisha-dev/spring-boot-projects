package com.example.Registration.CollegeRegistration.Model;

import jakarta.persistence.*;

@Entity
@Table(name="login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userEmail;
    private String password;

    public Login(String userEmail,String password){
        this.userEmail=userEmail;
        this.password=password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
