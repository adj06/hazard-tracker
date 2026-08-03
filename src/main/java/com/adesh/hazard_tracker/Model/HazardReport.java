package com.adesh.hazard_tracker.Model;

import jakarta.persistence.*; // JPA needed for database

@Entity // Class represents the table in database
@Table(name = "hazard_reports") // naming table in PostgreSQL
public class HazardReport {

    private Long id;
    private Double longitude;
    private Double latitude;
    private String title;
    private String description;
    private String status = "REPORTED";

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

    @Id // declaring the primary key for db
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatically generate new sequential number every time there is a new report
    public Long getId(){
        return id;
    }

    public Double getLongitude(){
        return longitude;
    }

    public Double getLatitude(){
        return latitude;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
