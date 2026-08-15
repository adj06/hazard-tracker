package com.adesh.hazard_tracker;

import com.adesh.hazard_tracker.model.HazardReport;
import com.adesh.hazard_tracker.model.HazardStatus;
import com.adesh.hazard_tracker.repository.HazardReportRepository;
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

// tells JUnit to enable Mockito for the class
@ExtendWith(MockitoExtension.class)
class testStatus {

    // creates test version of repo
    @Mock
    private HazardReportRepository repository;

    //creates service, plugs in test repo
    // test service without real db
    @InjectMocks
    private HazardReportService service;

    // runnable test method
    @Test

    public void testStatusSuccess(){

        Long testId = 1L;

        //creating report for test
        HazardReport testReport = new HazardReport();
        testReport.setId(testId);
        // testReport.getType();
        testReport.setStatus(HazardStatus.REPORTED);

        //returning test report when findById is called
        //used Optional.of() if findById finds nothing
        when(repository.findById(testId)).thenReturn(Optional.of(testReport));

        //the object passed into save() is returned (same object)
        when(repository.save(any(HazardReport.class))).thenAnswer(i -> i.getArguments()[0]);

        //call method inside service to test
        HazardReport updatedReport = service.updateStatus(testId, HazardStatus.RESOLVED);

        //check if service changed the status of report
        //pass in expected value and the actual value and message if fail
        assertEquals(HazardStatus.RESOLVED, updatedReport.getStatus());

    }

}
