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
        boolean isDuplicate = repository.existsByLatitudeAndLongitude(
                report.getLatitude(),
                report.getLongitude()
        );

        if (isDuplicate) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "hazard with the title already exists at this location"
            );
        }
        return repository.save(report);
    }

    public HazardReport updateStatus (Long id, String newStatus){
        HazardReport existingReport = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hazard not found with id: " + id));
        try {
            HazardStatus statusEnum = HazardStatus.valueOf(newStatus.toUpperCase());
            existingReport.setStatus(statusEnum);
        } catch (IllegalArgumentException e) {
            //If any other value is passed in then throw exception
            throw new RuntimeException("You have given an invalid status. Accepted values: REPORTED, SCHEDULED, UNDER_REVIEW, RESOLVED, DISMISSED.");
        }
        return repository.save(existingReport);


    }
}
