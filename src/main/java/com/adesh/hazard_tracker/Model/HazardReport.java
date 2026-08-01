package com.adesh.hazard_tracker.Model;

import jakarta.persistence.*; // JPA needed for database

@Entity // Class represents the table in database
@Table(name = "hazard_reports") // naming table in PostgreSQL
public class HazardReport {

    private long id;
    private double longitude;
    private double latitude;
    private String title;
    private String description;

    public HazardReport(long id, double longitude, double latitude, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public HazardReport() {

    }

    @Id // declaring the primary key for db
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatically generate new sequential number every time there is a new report
    public long getId(){
        return id;
    }

    public double getLongitude(){
        return longitude;
    }

    public double getLatitude(){
        return latitude;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }


}
