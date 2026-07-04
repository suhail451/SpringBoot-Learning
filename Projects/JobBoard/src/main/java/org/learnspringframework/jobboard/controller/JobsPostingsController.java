package org.learnspringframework.jobboard.controller;

import org.learnspringframework.jobboard.Data.JobsPostings;
import org.learnspringframework.jobboard.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("jobboard/api/jobs")
public class JobsPostingsController {


    /*
        POST   /api/jobs                 → add a new job posting
        GET    /api/jobs                 → return all job postings
        GET    /api/jobs/{id}             → return a single job by id
        GET    /api/jobs?location=Karachi → filter jobs by location
        GET    /api/jobs?type=Remote      → filter jobs by job type
        GET    /api/jobs/active           → return only jobs where isActive = true
        GET    /api/jobs/sorted           → return jobs sorted by postedDate or salary
    */

    private final JobService jobService;

    public JobsPostingsController(JobService jobService) {
        this.jobService = jobService;
    }


//  POST   /api/jobs                 → add a new job posting

    @PostMapping
    public ResponseEntity<JobsPostings> createNewJob(@RequestBody JobsPostings newJob){
        JobsPostings savedJob = jobService.save(newJob);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedJob.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

//  GET    /api/jobs                 → return all job postings
//    GET    /api/jobs?location=Karachi → filter jobs by location
//    GET    /api/jobs?type=Remote      → filter jobs by job type
//  -----------------------   OLD ---------
//    @GetMapping
//    public List<JobsPostings> getAllJobs(){
//       return jobService.getAllJobs();
//    }
//    --------- Updated -----
    @GetMapping
    public ResponseEntity<List<JobsPostings>> getJobs(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String jobType){

        if(( location != null &&  !location.isBlank()  ) && ( jobType != null && !jobType.isBlank()   ) ){

            return  ResponseEntity.ok(jobService.getJobsByLocationAndType(location, jobType));
        }

        if( location != null &&  !location.isBlank()  ){
           return  ResponseEntity.ok(jobService.getJobsByLocation(location));
        }

        if( jobType != null && !jobType.isBlank()   ){
            return ResponseEntity.ok(jobService.getJobsByType(jobType));
        }

        return ResponseEntity.ok(jobService.getAllJobs());
    }



//      GET    /api/jobs/{id}             → return a single job by id
    @GetMapping("/{id}")
    public ResponseEntity<JobsPostings> getJobById(@PathVariable Long id){
      return  ResponseEntity.ok(jobService.getById(id));
    }

//    GET    /api/jobs?location=Karachi → filter jobs by location
//    @GetMapping
//    public List<JobsPostings> getJobsByLocation(@RequestParam String location){
//        return jobService.getJobsByLocation(location);
//    }   ---> Error aye gha k eik hi end point per 2 methods Call krne prh rahy hain Spring Confuse Ho raha hy

//      GET    /api/jobs/active           → return only jobs where isActive = true
    @GetMapping("/active")
    public ResponseEntity<List<JobsPostings>> getOnlyActiveJobs(){
        return ResponseEntity.ok(jobService.getOnlyActiveJobs());
    }

//     GET    /api/jobs/sorted           → return jobs sorted by postedDate or salary
    @GetMapping("/sorted")
    public ResponseEntity<List<JobsPostings>> getJobSorted(
            @RequestParam(defaultValue = "postedDate") String sortBy
    ){
        return ResponseEntity.ok(jobService.getJobSorted(sortBy));
    }


//    Update
    @PutMapping("/update/{id}")
    public ResponseEntity<JobsPostings> updateJob(@PathVariable Long id ,@RequestBody JobsPostings jobsPostings){
           jobService.updateJob( id ,jobsPostings);
        return ResponseEntity.ok().build();
    }

//    Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JobsPostings> deleteJob(@PathVariable Long id){
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }



}
