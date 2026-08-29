package com.adesh.hazard_tracker.dto;

import com.adesh.hazard_tracker.model.HazardSeverity;
import com.adesh.hazard_tracker.model.HazardType;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class HazardReportRequest {

    @NotNull(message = "Longitude can't be null")
    @DecimalMin(value = "-180.0", message = "Longitude minimum is -180.0")
    @DecimalMax(value = "180.0", message = "Longitude maximum is 180.0")
    private Double longitude;

    @NotNull(message = "Latitude can't be null")
    @DecimalMin(value = "-90.0", message = "Latitude minimum is -90.0")
    @DecimalMax(value = "90.0", message = "Latitude maximum is 90.0")
    private Double latitude;

    @NotNull(message = "HazardType can't be null")
    private HazardType type;

    @NotNull(message = "Hazard severity can't be null")
    private HazardSeverity severity;

    @NotBlank(message = "Description can't be blank")
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
