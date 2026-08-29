package com.adesh.hazard_tracker.service;

import com.adesh.hazard_tracker.dto.HazardReportRequest;
import com.adesh.hazard_tracker.dto.HazardReportResponse;
import com.adesh.hazard_tracker.model.HazardReport;
import com.adesh.hazard_tracker.model.HazardStatus;
import com.adesh.hazard_tracker.repository.HazardReportRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

// manage business logic
@Service
public class HazardReportService {

    private final HazardReportRepository repository;

    // map Repository to this Service
    public HazardReportService(HazardReportRepository repository) {
        this.repository = repository;
    }

    // fetching hazards from db
    public List<HazardReportResponse> getHazards() {
        return repository.findAll().stream().map(this::convertToResponse).toList();
    }

    // method to save hazard to db
    public HazardReportResponse createHazard(@org.jetbrains.annotations.UnknownNullability @Valid HazardReportRequest request) {

        boolean duplicate = repository.existsByTypeAndLatitudeAndLongitude(request.getType(), request.getLatitude(), request.getLongitude());

        if (duplicate) {
            throw new IllegalArgumentException("Hazard of type already exists at location");
        }

        HazardReport report = new HazardReport();

        report.setLongitude(request.getLongitude());
        report.setLatitude(request.getLatitude());
        report.setType(request.getType());
        report.setSeverity(request.getSeverity());
        report.setDescription(request.getDescription());

        HazardReport savedReport = repository.save(report);

        return convertToResponse(savedReport);
    }

    public HazardReportResponse updateStatus(Long id, HazardStatus newStatus) {

        HazardReport report = repository.findById(id).orElseThrow(() -> new RuntimeException("Hazard not found with id: " + id));

        report.setStatus(newStatus);

        HazardReport updatedReport = repository.save(report);

        return convertToResponse(updatedReport);
    }

    public HazardReportResponse getHazardById(Long id) {

        HazardReport report = repository.findById(id).orElseThrow(() -> new RuntimeException("Hazard not found with id: " + id));

        return convertToResponse(report);
    }

    private HazardReportResponse convertToResponse(HazardReport report){
        return new HazardReportResponse(report.getId(), report.getLongitude(), report.getLatitude(), report.getType(), report.getSeverity(), report.getDescription(), report.getStatus(), report.getReportedTime(), report.getUpdatedTime());
    }

    }


