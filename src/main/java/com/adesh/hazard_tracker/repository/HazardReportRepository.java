package com.adesh.hazard_tracker.repository;

import com.adesh.hazard_tracker.model.HazardReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // the file is in charge of talking to db
// telling JPA what entity is managed and the primary key
public interface HazardReportRepository extends JpaRepository<HazardReport, Long> {

    boolean existsByLatitudeAndLongitude(Double latitude, Double longitude);


}
