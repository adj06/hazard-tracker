package com.adesh.hazard_tracker.controller;
import com.adesh.hazard_tracker.dto.HazardReportRequest;
import com.adesh.hazard_tracker.dto.HazardReportResponse;
import com.adesh.hazard_tracker.model.HazardStatus;
import com.adesh.hazard_tracker.service.HazardReportService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // telling spring this file handles web requests
@RequestMapping("/api/v1/hazards") // base URL for endpoint
public class HazardReportController {

    private final HazardReportService service;

    public HazardReportController(HazardReportService service) {
        this.service = service;
    }

    @GetMapping // maps HTTP GET requests to getHazards method
    public List<HazardReportResponse> getHazards(){
        return service.getHazards();
    }

    @GetMapping("/{id}")
    public HazardReportResponse getHazardById(@PathVariable Long id) {
        return service.getHazardById(id);
    }

    @PostMapping// map HTTP POST requests to createHazard method
    public HazardReportResponse createHazard(@Valid @RequestBody HazardReportRequest request){ // takes incoming JSON from requests converts to Hazard Report object
        return service.createHazard(request);
    }

    @PatchMapping("/{id}/status")
    public HazardReportResponse updateHazardStatus(@PathVariable Long id, @RequestParam HazardStatus status) {
        return service.updateStatus(id, status);
    }

    /*@DeleteMapping
    public HazardReport deleteHazardStatus(){
    }*/
}