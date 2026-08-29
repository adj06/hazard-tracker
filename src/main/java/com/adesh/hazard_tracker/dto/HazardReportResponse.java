package com.adesh.hazard_tracker.dto;

import com.adesh.hazard_tracker.model.HazardSeverity;
import com.adesh.hazard_tracker.model.HazardStatus;
import com.adesh.hazard_tracker.model.HazardType;

import java.time.LocalDateTime;

public class HazardReportResponse {

    private Long id;
    private Double longitude;
    private Double latitude;
    private HazardType type;
    private HazardSeverity severity;
    private String description;
    private HazardStatus status;
    private LocalDateTime reportedTime;
    private LocalDateTime updatedTime;

    public HazardReportResponse(Long id, Double longitude, Double latitude, HazardType type, HazardSeverity severity, String description, HazardStatus status, LocalDateTime reportedTime, LocalDateTime updatedTime){
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.type = type;
        this.severity = severity;
        this.description = description;
        this.status = status;
        this.reportedTime = reportedTime;
        this.updatedTime = updatedTime;
    }

    public Long getId() {
        return id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public HazardType getType() {
        return type;
    }

    public HazardSeverity getSeverity() {
        return severity;
    }

    public String getDescription() {
        return description;
    }

    public HazardStatus getStatus() {
        return status;
    }

    public LocalDateTime getReportedTime() {
        return reportedTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }
}
