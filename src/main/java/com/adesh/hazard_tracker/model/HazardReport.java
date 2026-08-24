package com.adesh.hazard_tracker.model;

import jakarta.persistence.*; // JPA needed for database
import jakarta.validation.constraints.*; // validation library
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity // Class represents the table in database
@Table(name = "hazard_reports") // naming table in PostgreSQL
public class HazardReport {


    @Id // declaring the primary key for db
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    // automatically generate new sequential number every time there is a new report
    private Long id;

    //annotations for validation
    @NotNull(message = "Longitude can't be null")
    @DecimalMin(value = "-180.0", message = "Longitude has to be a minimum of -180.0")
    @DecimalMax(value = "180.0", message = "Longitude has to be a maximum of 180.0")
    private Double longitude;

    @NotNull(message = "Latitude can't be null")
    @DecimalMin(value = "-90", message = "Latitude has to be a minimum of -90.0")
    @DecimalMax(value = "90", message = "Latitude has to be a maximum of 90.0")
    private Double latitude;

    @NotNull(message = "Hazard type can't be null")
    @Enumerated(EnumType.STRING)
    private HazardType type;

    @NotNull(message = "Hazard severity can't be null")
    @Enumerated(EnumType.STRING)
    private HazardSeverity severity;

    @NotBlank(message = "description can't be blank")
    private String description;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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

    public HazardSeverity getSeverity() {
        return severity;
    }
    public void setSeverity(HazardSeverity severity){
        this.severity = severity;
    }

    public HazardType getType() {
        return type;
    }

    public void setType(HazardType type){
        this.type = type;
    }


}
