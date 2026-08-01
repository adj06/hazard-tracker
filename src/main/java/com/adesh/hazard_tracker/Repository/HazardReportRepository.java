package com.adesh.hazard_tracker.Repository;

import com.adesh.hazard_tracker.Model.HazardReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // the file is in charge of talking to db
// telling JPA what entity is managed and the primary key
public interface HazardReportRepository extends JpaRepository<HazardReport, Long> {


}
