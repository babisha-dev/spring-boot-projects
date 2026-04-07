package com.example.Registration.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
  //  private Project project;

   // private Employee employee;
    private int hoursWorked;
}
