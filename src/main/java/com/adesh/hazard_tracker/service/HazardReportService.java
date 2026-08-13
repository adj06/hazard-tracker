package com.adesh.hazard_tracker.service;

import com.adesh.hazard_tracker.model.HazardReport;
import com.adesh.hazard_tracker.model.HazardStatus;
import com.adesh.hazard_tracker.repository.HazardReportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public List<HazardReport> getHazards() {
        return repository.findAll();
    }

    // method to save hazard to db
    public HazardReport createHazard(HazardReport report){
        boolean duplicate = repository.existsByTypeAndLatitudeAndLongitude(report.getType(), report.getLatitude(), report.getLongitude());

        if (duplicate){
            throw new IllegalArgumentException("There's already a hazard of the type that exists at the location");
        }
        return repository.save(report);
    }

    public HazardReport updateStatus (Long id, String newStatus){

        HazardReport report = repository.findById(id).orElseThrow(() -> new RuntimeException("Hazard not found with id: " + id));
        HazardStatus status;

        try {
            status = HazardStatus.valueOf(newStatus.toUpperCase());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid hazard status: " + newStatus);
        }

        report.setStatus(status);
        return repository.save(report);

    }
}
