package com.adesh.hazard_tracker.dto;

import com.adesh.hazard_tracker.model.HazardSeverity;
import com.adesh.hazard_tracker.model.HazardType;


public class HazardReportRequest {

    private Double longitude;

    private Double latitude;

    private HazardType type;

    private HazardSeverity severity;

    private String description;

    public HazardReportRequest(){

    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }

    public Double getLongitude(){
        return longitude;
    }

    public void setLongitude(Double longitude){
        this.longitude = longitude;
    }

    public HazardType getType(){
        return type;
    }

    public void setType(HazardType type){
        this.type = type;
    }

    public HazardSeverity getSeverity(){
        return severity;
    }

    public void setSeverity(HazardSeverity severity){
        this.severity = severity;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }













}
