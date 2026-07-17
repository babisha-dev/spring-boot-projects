package com.example.Registration.CollegeRegistration.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="students")
@Schema(description = "Student entity representing a registered student")
public class Student {
    @Schema(description = "Unique student Identifier" ,example = "1002")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Student Full name", example = "John Doe", required= true)
    @NotBlank(message = "Name Cannot be Blank")
    @Column(unique = true)
    private String userName;

    @Schema(description = "Student email id", example = "johndoe@gmail.com")
    @Email(message = "Enter the correct email format")
    @NotBlank(message = "Field cannot be empty")
    @Column(unique = true)
    private String userEmail;

    @Schema(description = "Student 10 digit phone number", example = "0987654321")
    @Pattern(regexp = "^[0-9]{10}$", message=("Please Enter a 10 digit value"))
    private  String phoneNo;

    @Schema(description = "student latest neet exam score")
    @Min(value = 0, message = "Minimum value is 0")
    @Max(value=720, message = "Maximum value is 720")
    private int neetScore;
    private String category;
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "student" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MockTest> mockTest;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private  List<Result> result;
    @OneToMany(mappedBy = "student", cascade=CascadeType.ALL)
    private List<Subject> subject;

    @PrePersist
    protected  void createdAt(){
        createdAt=LocalDateTime.now();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public long getId() {
        return id;
    }

    public int getNeetScore() {
        return neetScore;
    }

    public String getCategory() {
        return category;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setCreatedAt(LocalDateTime createdAt) {

        this.createdAt = createdAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setNeetScore(int neetScore) {
        this.neetScore = neetScore;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
