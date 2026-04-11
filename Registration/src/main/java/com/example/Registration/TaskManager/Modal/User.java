package com.example.Registration.TaskManager.Modal;

import jakarta.persistence.*;

import javax.management.relation.Role;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String userEmail;
    private String password;
    @Enumerated(EnumType.STRING )
    private RoleType role;
    private LocalDateTime createdAt;
    @PrePersist
    protected void createdAt(){
        createdAt=LocalDateTime.now();
    }
    public   enum RoleType{
        USER, ADMIN
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }

    public RoleType getRole() {

        return role;
    }

    public String getUserName() {

        return userName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setId(long id) {

        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}
