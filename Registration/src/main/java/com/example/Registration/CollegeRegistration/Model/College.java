package com.example.Registration.CollegeRegistration.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
@Schema(description = "college entity representing a registered college")
@Entity
@Table(name="colleges")
public class College {
    @Schema(description="Unique  college identifier", example = "1001")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Schema(description = "College  name", required=true)
    private String collegeName;
    @Schema(description = "college located state" ,example="tamil nadu")
    private String state;
    private String type;
    @Schema(description = "college annual fee in rupees")
    private  double fees;
    @Schema(description = "is college currently active")
    private  boolean active=true;
    private int cutOffScore;


    public long getId() {
        return id;
    }

    public double getFees() {
        return fees;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getState() {
        return state;
    }

    public String getType() {
        return type;
    }

    public boolean isActive() {
        return active;
    }

    public int getCutOffScore() {
        return cutOffScore;
    }

    public void setCutOffScore(int cutOffScore) {
        this.cutOffScore = cutOffScore;
    }

    public void setActive(boolean active) {
        active = active;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setType(String type) {
        this.type = type;
    }
}