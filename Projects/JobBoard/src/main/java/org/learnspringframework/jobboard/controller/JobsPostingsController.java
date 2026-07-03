package org.learnspringframework.jobboard.controller;

import org.learnspringframework.jobboard.Data.JobsPostings;
import org.learnspringframework.jobboard.service.JobService;
import org.springframework.web.bind.annotation.*;

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
    public JobsPostings createNewJob(@RequestBody JobsPostings newJob){
        jobService.save(newJob);
        return newJob;
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
    public List<JobsPostings> getJobs(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String jobType){

        if(( location != null &&  !location.isBlank()  ) && ( jobType != null && !jobType.isBlank()   ) ){
            System.out.println("Wait");
        }

        if( location != null &&  !location.isBlank()  ){
           return  jobService.getJobsByLocation(location);
        }

        if( jobType != null && !jobType.isBlank()   ){
            return jobService.getJobsByType(jobType);
        }

        return jobService.getAllJobs();
    }



//      GET    /api/jobs/{id}             → return a single job by id
    @GetMapping("/{id}")
    public JobsPostings getJobById(@PathVariable Long id){
      return   jobService.getById(id);

    }

//    GET    /api/jobs?location=Karachi → filter jobs by location
//    @GetMapping
//    public List<JobsPostings> getJobsByLocation(@RequestParam String location){
//        return jobService.getJobsByLocation(location);
//    }   ---> Error aye gha k eik hi end point per 2 methods Call krne prh rahy hain Spring Confuse Ho raha hy

//      GET    /api/jobs/active           → return only jobs where isActive = true
    @GetMapping("/active")
    public List<JobsPostings> getOnlyActiveJobs(){
        return jobService.getOnlyActiveJobs();
    }

//     GET    /api/jobs/sorted           → return jobs sorted by postedDate or salary
    @GetMapping("/sorted")
    public List<JobsPostings> getJobSorted(
            @RequestParam(defaultValue = "postedDate") String sortBy
    ){
        return jobService.getJobSorted(sortBy);
    }



}
