package com.adesh.hazard_tracker.Model;


public class HazardReport {

    private long id;
    private long longitude;
    private long latitude;
    private String title;
    private String description;

    public HazardReport(long id, long longitude, long latitude, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
    }

}
