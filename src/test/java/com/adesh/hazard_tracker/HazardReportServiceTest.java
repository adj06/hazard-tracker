package com.adesh.hazard_tracker;

import com.adesh.hazard_tracker.dto.HazardReportRequest;
import com.adesh.hazard_tracker.dto.HazardReportResponse;
import com.adesh.hazard_tracker.model.HazardReport;
import com.adesh.hazard_tracker.model.HazardSeverity;
import com.adesh.hazard_tracker.model.HazardStatus;
import com.adesh.hazard_tracker.model.HazardType;
import com.adesh.hazard_tracker.repository.HazardReportRepository;
import com.adesh.hazard_tracker.service.HazardReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

// tells JUnit to enable Mockito for the class
@ExtendWith(MockitoExtension.class)
class HazardReportServiceTest {

    // creates test version of repo
    @Mock
    private HazardReportRepository repository;

    //creates service, plugs in test repo
    // test service without real db
    @InjectMocks
    private HazardReportService service;

    // runnable test method
    @Test
    public void testUpdateHazardStatus(){

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
        HazardReportResponse updatedReport = service.updateStatus(testId, HazardStatus.RESOLVED);

        //check if service changed the status of report
        //pass in expected value and the actual value and message if fail
        assertEquals(HazardStatus.RESOLVED, updatedReport.getStatus());
        assertEquals(HazardStatus.RESOLVED, testReport.getStatus());

    }

    @Test
    void testThrowExceptionWhenHazardNotExist(){
        Long testId = 999L;

        // return empty optional when hazard id not found
        when(repository.findById(testId)).thenReturn(Optional.empty());
        // check service throws exception when hazard not exist
        assertThrows(RuntimeException.class,()-> service.updateStatus(testId, HazardStatus.RESOLVED));
    }

    @Test
    void testSaveUpdatedHazard(){

        Long testId = 1L;

        HazardReport testReport = new HazardReport();
        testReport.setId(testId);
        testReport.setStatus(HazardStatus.REPORTED);

        // return same hazard object when save is called
        when(repository.findById(testId)).thenReturn(Optional.of(testReport));
        when(repository.save(any(HazardReport.class))).thenAnswer((i-> i.getArguments()[0]));

        //verify updated hazard passed to repo
        service.updateStatus(testId,HazardStatus.RESOLVED);
        verify(repository).save(testReport);


    }

    @Test
    void testRejectDuplicate(){

        HazardReportRequest testRequest = new HazardReportRequest();

        testRequest.setType(HazardType.POTHOLE);
        testRequest.setSeverity(HazardSeverity.HIGH);
        testRequest.setLatitude(51.5074);
        testRequest.setLongitude(-0.1278);
        testRequest.setDescription("Large pothole");

        //return true when hazard with same type and location exist
        when(repository.existsByTypeAndLatitudeAndLongitude(HazardType.POTHOLE, 51.5074,-0.1278)).thenReturn(true);
        //check service rejects duplicate hazard
        assertThrows(IllegalArgumentException.class,() -> service.createHazard(testRequest));
        //verify duplicate hazard wasn't saved
        verify(repository, never()).save(any(HazardReport.class));
    }

    @Test
    void testCreateHazard(){

        HazardReportRequest testRequest = new HazardReportRequest();

        testRequest.setType(HazardType.POTHOLE);
        testRequest.setSeverity(HazardSeverity.HIGH);
        testRequest.setLatitude(51.5074);
        testRequest.setLongitude(-0.1278);
        testRequest.setDescription("Large pothole");

        when(repository.save(any(HazardReport.class))).thenAnswer(i-> {
            HazardReport report = i.getArgument(0);
            report.setId(1L);
            return report;
        });

        HazardReportResponse response = service.createHazard(testRequest);

        assertEquals(1L, response.getId());
        assertEquals(HazardType.POTHOLE, response.getType());
        assertEquals(HazardSeverity.HIGH, response.getSeverity());
        assertEquals(51.5074, response.getLatitude());
        assertEquals(-0.1278, response.getLongitude());
        assertEquals("Large pothole", response.getDescription());

        verify(repository).save(any(HazardReport.class));


    }



}
