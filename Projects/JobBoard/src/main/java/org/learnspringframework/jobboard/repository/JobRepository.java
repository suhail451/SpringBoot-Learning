package org.learnspringframework.jobboard.repository;

import org.learnspringframework.jobboard.Data.JobsPostings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JobRepository extends JpaRepository<JobsPostings, Long> {

//    Custom Methods
    List<JobsPostings> findByTitleIgnoreCase(String title);

    List<JobsPostings> findByCompanyName(String companyName);

    List<JobsPostings> findByJobType(String jobType);

    List<JobsPostings> findByIsActiveTrue();


    List<JobsPostings> findByLocationIgnoreCase(String Location);

}
