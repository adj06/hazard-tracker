package com.adesh.hazard_tracker.controller;
import com.adesh.hazard_tracker.model.HazardReport;
import com.adesh.hazard_tracker.model.HazardStatus;
import com.adesh.hazard_tracker.repository.HazardReportRepository;
import com.adesh.hazard_tracker.service.HazardReportService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // telling spring this file handles web requests
@RequestMapping("/api/v1/hazards") // base URL for endpoint
public class HazardReportController {

    private final HazardReportService service;

    public HazardReportController(HazardReportRepository repository, HazardReportService service) {
        this.service = service;
    }

    @GetMapping // maps HTTP GET requests to getHazards method
    public List<HazardReport> getHazards(){
        return service.getHazards();
    }

    @PostMapping// map HTTP POST requests to createHazard method
    public HazardReport createHazard(@Valid @RequestBody HazardReport report){ // takes incoming JSON from requests converts to Hazard Report object
        return service.createHazard(report);
    }

    @PatchMapping("/{id}/status")
    public HazardReport updateHazardStatus(@PathVariable Long id, @RequestParam HazardStatus status) {
        return service.updateStatus(id, status);
    }

    //@DeleteMapping
    //public HazardReport deleteHazardStatus(){

    //}
}