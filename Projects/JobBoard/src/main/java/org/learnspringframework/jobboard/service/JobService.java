package org.learnspringframework.jobboard.service;

import jakarta.validation.Valid;
import org.learnspringframework.jobboard.Data.JobsPostings;
import org.learnspringframework.jobboard.dtos.JobRequestDto;
import org.learnspringframework.jobboard.dtos.JobResponseDTO;
import org.learnspringframework.jobboard.exceptions.InvalidJobDataException;
import org.learnspringframework.jobboard.exceptions.JobNotFoundException;
import org.learnspringframework.jobboard.storage.JobStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class JobService {

    private JobStorage jobStorage;

     Logger logger = LoggerFactory.getLogger(JobService.class);

    public JobService(JobStorage jobStorage) {
        this.jobStorage = jobStorage;
    }


    public JobsPostings save(JobRequestDto newJobRequest) {
        logger.debug("Creating Job -- DEBUG");
        logger.error("Creating Job - ERROR");
        logger.info("Creating Job --- INFO");
        logger.trace("Creating Log for job on TRACE Level");

//        OUTPUT
        /*
        *   2026-07-07T21:06:34.078+05:00 DEBUG 1696 --- [JobBoard] [nio-8080-exec-3] o.l.j.controller.JobsPostingsController  : Creating Job -- DEBUG
            2026-07-07T21:06:34.078+05:00 ERROR 1696 --- [JobBoard] [nio-8080-exec-3] o.l.j.controller.JobsPostingsController  : Creating Job - ERROR
            2026-07-07T21:06:34.078+05:00  INFO 1696 --- [JobBoard] [nio-8080-exec-3] o.l.j.controller.JobsPostingsController  : Creating Job --- INFO
            2026-07-07T21:06:34.078+05:00 TRACE 1696 --- [JobBoard] [nio-8080-exec-3] o.l.j.controller.JobsPostingsController  : Creating Log for job on TRACE Level
            * */
        JobsPostings newJob =  mapToEntity(newJobRequest);
        validator(newJob);
        jobStorage.save(newJob);
        return newJob;
    }


    public List<JobResponseDTO> getAllJobs() {
        return jobStorage.getAllJobs().stream()
                .map(this::mapToJobResponseDto)
                .toList();
    }


    public JobResponseDTO getById(Long id) {
        JobsPostings jobsPostings = jobStorage.getById(id).orElse(null);
        chackJobIfNull(id ,jobsPostings);
        return mapToJobResponseDto(jobsPostings);
    }


    public List<JobResponseDTO> getJobsByLocation(String location) {
       return jobStorage.getAllJobs()
                .stream()
                .filter(job -> job.getLocation().equalsIgnoreCase(location))
               .map(this::mapToJobResponseDto)
                .toList();
    }


    public List<JobResponseDTO> getJobsByType(String type) {
        return jobStorage.getAllJobs()
                .stream()
                .filter(job -> job.getJobType().equalsIgnoreCase(type))
                .map(this::mapToJobResponseDto)
                .toList();
    }

    public List<JobResponseDTO> getOnlyActiveJobs() {
        return jobStorage.getAllJobs()
                .stream()
                .filter(job -> job.isActive())
                .map(this::mapToJobResponseDto)
                .toList();
    }

    public List<JobResponseDTO> getJobSorted(String sortBy) {

        if (sortBy.equalsIgnoreCase("postedDate")) {
            return jobStorage.getAllJobs()
                    .stream()
                    .sorted(Comparator.comparing(JobsPostings::getPostedDate).reversed())
                    .map(this::mapToJobResponseDto)
                    .toList();
        }

        if(sortBy.equalsIgnoreCase("salary")){
            return jobStorage.getAllJobs()
                    .stream()
                    .sorted(Comparator.comparing( job ->  exactMinsalary(job.getSalaryRange())))
                    .map(this::mapToJobResponseDto)
                    .toList();
        }

        if(sortBy.equalsIgnoreCase("salaryHighToLow")){
            return jobStorage.getAllJobs()
                    .stream()
                    .sorted(Comparator.comparing(  (JobsPostings job) ->  exactMinsalary(job.getSalaryRange())).reversed())
                    .map(this::mapToJobResponseDto)
                    .toList();
        }
        return  jobStorage.getAllJobs().stream().map(this::mapToJobResponseDto).toList();
    }



    public List<JobResponseDTO> getJobsByLocationAndType(String location, String jobType) {
        return JobStorage.getAllJobs()
                .stream()
                .filter(job -> job.getLocation().equalsIgnoreCase(location)
                                    && job.getJobType().equalsIgnoreCase(jobType))
                .map(this::mapToJobResponseDto)
                .toList();
    }

    public void updateJob(long id, @Valid JobRequestDto newJobRequest) {
        JobsPostings newJob = mapToEntity(newJobRequest);
        validator(newJob);
        JobsPostings jobsPostings1 = jobStorage.getById(id).orElse(null);
        chackJobIfNull(id ,jobsPostings1);
        jobStorage.updateJob(id, newJob);
    }


    public void deleteJob(Long id) {
        JobsPostings jobsPostings = jobStorage.getById(id).orElse(null);
        chackJobIfNull(id ,jobsPostings);
        jobStorage.delete(jobsPostings);
    }


//    Extra Logics
    private int exactMinsalary(String salaryRange) {
        if(salaryRange == null || salaryRange.isBlank()){
            return 0;
        }
        String minSalary = salaryRange.split("-")[0]
                .replace("k", "")
                .replace("K", "")
                .trim();
        return Integer.parseInt(minSalary);
    }

//    ResponseDto Mappings;
    public JobResponseDTO mapToJobResponseDto(JobsPostings job){
        return new JobResponseDTO(
                job.getId(),
                job.getTitle(),
                job.getJobDescription(),
                job.getCompanyName(),
                job.getLocation(),
                job.getSalaryRange(),
                job.getJobType(),
                job.getPostedDate(),
                job.isActive()
        );
    }

//    RequestDto Mapping
    public JobsPostings mapToEntity(JobRequestDto job){
        return new JobsPostings(
                null, // Id Automatically Generate hojae ghi
                job.getTitle(),
                job.getJobDescription(),
                job.getCompanyName(),
                job.getLocation(),
                job.getSalaryRange(),
                job.getJobType(),
                job.getPostedDate(),
                job.getActive()
        );
    }


//    Validate the Object manually
    private void validator(JobsPostings newJob) {
        if(         (newJob.getTitle() == null || newJob.getTitle().trim().isBlank())
                || (newJob.getJobType() == null || newJob.getJobType().trim().isBlank())
                || (newJob.getJobDescription() == null || newJob.getJobDescription().trim().isBlank())
                || (newJob.getLocation() == null || newJob.getLocation().trim().isBlank())
                || (newJob.getSalaryRange() == null || newJob.getSalaryRange().trim().isBlank())
                || (newJob.getCompanyName() == null || newJob.getCompanyName().trim().isBlank())
                || (newJob.getPostedDate().isBefore(LocalDate.now().minusDays(7)))){

            if(newJob.getPostedDate().isBefore(LocalDate.now().minusDays(7))){
                logger.info("Date Should have On 7 days in past");
                throw new InvalidJobDataException( "Date Should have On 7 days in past" );
            }

            logger.error("Enter All Fields Must");

            throw new InvalidJobDataException( "Please Enter All The Fields must!" );
        }
    }

//    check the job is null or not
    private void chackJobIfNull( Long id , JobsPostings jobsPostings) {
        if(jobsPostings == null){
            throw new JobNotFoundException("This Job with id : " +  id + " is not Found");
        }
    }

}
