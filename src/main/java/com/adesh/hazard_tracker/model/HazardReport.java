package com.adesh.hazard_tracker.model;

import jakarta.persistence.*; // JPA needed for database

@Entity // Class represents the table in database
@Table(name = "hazard_reports") // naming table in PostgreSQL
public class HazardReport {


    @Id // declaring the primary key for db
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // automatically generate new sequential number every time there is a new report
    private Long id;
    private Double longitude;
    private Double latitude;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private HazardStatus status = HazardStatus.REPORTED;

    public HazardReport(Long id, Double longitude, Double latitude, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    // empty constructor for JPA
    public HazardReport() {

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // Updated Getter and Setter for the new Enum type
    public HazardStatus getStatus() {
        return status;
    }
    public void setStatus(HazardStatus status) {
        this.status = status;
    }


}
