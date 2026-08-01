package com.adesh.hazard_tracker.service;

import com.adesh.hazard_tracker.Model.HazardReport;
import com.adesh.hazard_tracker.Repository.HazardReportRepository;
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
    public List<HazardReport> getHazards() {
        return repository.findAll();
    }

    // method to save hazard to db
    public HazardReport createHazard(HazardReport report){
        return repository.save(report);
    }
}
