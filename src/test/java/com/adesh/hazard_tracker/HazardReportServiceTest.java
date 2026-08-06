package com.adesh.hazard_tracker;

import com.adesh.hazard_tracker.Model.HazardReport;
import com.adesh.hazard_tracker.Repository.HazardReportRepository;
import com.adesh.hazard_tracker.service.HazardReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class testStatus {

    @Mock
    private HazardReportRepository repository;

    @InjectMocks
    private HazardReportService service;

    @Test

    public void testStatusSuccess(){

        Long testId = 1L;

        HazardReport testReport = new HazardReport();
        testReport.setId(testId);
        testReport.setTitle("Test Hazard");
        testReport.setStatus("REPORTED");

        when(repository.findById(testId)).thenReturn(Optional.of(testReport));
        when(repository.save(any(HazardReport.class))).thenAnswer(i -> i.getArguments()[0]);

        HazardReport updatedReport = service.updateStatus(testId, "RESOLVED");
        assertEquals("RESOLVED", updatedReport.getStatus(), "The status should be successfully updated to RESOLVED");

    }

}