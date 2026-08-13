package com.adesh.hazard_tracker.model;

import jakarta.persistence.*; // JPA needed for database
import jakarta.validation.constraints.*;


@Entity // Class represents the table in database
@Table(name = "hazard_reports") // naming table in PostgreSQL
public class HazardReport {


    @Id // declaring the primary key for db
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // automatically generate new sequential number every time there is a new report
    private Long id;

    @NotNull(message = "Longitude can't be null")
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private Double longitude;

    @NotNull(message = "Latitude can't be null")
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private Double latitude;

    @NotNull(message = "Hazard type can't be null")
    @Enumerated(EnumType.STRING)
    private HazardType type;

    @NotBlank(message = "description can't be blank")
    private String description;

    @Enumerated(EnumType.STRING)
    private HazardStatus status = HazardStatus.REPORTED;

    public HazardReport(Long id, Double longitude, Double latitude, HazardType type, String description) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.type = type;
        this.description = description;
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

    public HazardType getType() {
        return type;
    }

    public void setType(HazardType type){
        this.type = type;
    }


}
