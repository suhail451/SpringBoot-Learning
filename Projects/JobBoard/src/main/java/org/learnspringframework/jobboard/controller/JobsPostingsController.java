package org.learnspringframework.jobboard.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.learnspringframework.jobboard.Data.JobsPostings;
import org.learnspringframework.jobboard.dtos.JobRequestDto;
import org.learnspringframework.jobboard.dtos.JobResponseDTO;
import org.learnspringframework.jobboard.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "Job postings", description = "APIs for managing Job Postings")
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

    @Operation(summary = "Create Job", description = "Post api for Adding Request in Databases")
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = "Working well"),
            @ApiResponse(responseCode = "400" , description = "Invalid Input fields"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<JobRequestDto> createNewJob(@Valid @RequestBody JobRequestDto newJob){
        JobsPostings savedJob = jobService.save(newJob);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedJob.getId())
                .toUri();

        if(savedJob == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

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
//    --------- Updated ---------   ---> Issue
    @Operation(summary = "Retrive Jobs", description = "Retrive Jobs from database, you can Search from Request perameter Location and JobType")
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = "Working well"),
            @ApiResponse(responseCode =  "404", description = "Job Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public  ResponseEntity<List<JobResponseDTO>> getJobs(
            @Parameter(description = "location parameter")
            @RequestParam(required = false) String location,
            @Parameter(description = "jobType parameter")
            @RequestParam(required = false) String jobType,
            @Parameter(description = "Company name")
            @RequestParam(required = false) String companyname,
            @Parameter(description = "title")
            @RequestParam(required = false) String title
    ){

        if(( location != null &&  !location.isBlank()  ) && ( jobType != null && !jobType.isBlank() && ( companyname != null && !companyname.isBlank())  && (title != null && !title.isBlank())  ) ){
            return  ResponseEntity.ok(jobService.getJobsByLocationAndTypeAndCompanyNameAndTitle(location, jobType, companyname, title));
        }

        if(( location != null &&  !location.isBlank()  ) && ( jobType != null && !jobType.isBlank() && ( companyname != null && !companyname.isBlank())   ) ){
            return  ResponseEntity.ok(jobService.getJobsByLocationAndTypeAndCompanyName(location, jobType, companyname));
        }

        if(( location != null &&  !location.isBlank()  ) && ( jobType != null && !jobType.isBlank()   ) ){
            return  ResponseEntity.ok(jobService.getJobsByLocationAndType(location, jobType));
        }


        if(title != null && !title.isBlank()){
            return ResponseEntity.ok(jobService.getByTitle(title));
        }

        if( companyname != null && !companyname.isBlank()){
            return ResponseEntity.ok(jobService.getByCompanyName(companyname));
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
    @Operation(summary = "Retrive data", description = "Get Job by jobId")
    @GetMapping("/{id}")
    public ResponseEntity<JobResponseDTO> getJobById(@PathVariable Long id){
      return  ResponseEntity.ok(jobService.getById(id));
    }

//    GET    /api/jobs?location=Karachi → filter jobs by location
//    @GetMapping
//    public List<JobsPostings> getJobsByLocation(@RequestParam String location){
//        return jobService.getJobsByLocation(location);
//    }   ---> Error aye gha k eik hi end point per 2 methods Call krne prh rahy hain Spring Confuse Ho raha hy
//      GET    /api/jobs/active           → return only jobs where isActive = true

    @Operation(summary = "Active Jobs", description = "→ return only jobs where isActive = true")
    @GetMapping("/active")
    public ResponseEntity<List<JobResponseDTO>> getOnlyActiveJobs(){
        return ResponseEntity.ok(jobService.getOnlyActiveJobs());
    }

//     GET    /api/jobs/sorted           → return jobs sorted by postedDate or salary
    @Operation(summary = "sorted Jobs", description = "→ return only sorted Jobs")
    @GetMapping("/sorted")
    public ResponseEntity<List<JobResponseDTO>> getJobSorted(
            @Parameter(description = "sortBy Parameter (postedDate , salaryRange) ")
            @RequestParam(defaultValue = "postedDate") String sortBy
    ){
        return ResponseEntity.ok(jobService.getJobSorted(sortBy));
    }


//    Update
    @Operation(summary = "Update", description = "Update job from the job id")
    @PutMapping("/{id}")
    public ResponseEntity<JobRequestDto> updateJob( @PathVariable Long id ,@Valid @RequestBody JobRequestDto updatedJobRequest){

           jobService.updateJob( id ,updatedJobRequest);
        return ResponseEntity.ok().build();
    }

//    Delete
    @Operation(summary = "Delete", description = "delete any Job By id")
    @DeleteMapping("/{id}")
    public ResponseEntity<JobsPostings> deleteJob(@PathVariable Long id){
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/company/{CompanyName}")
    public ResponseEntity< List<JobResponseDTO>> getByCompanyName(@PathVariable String CompanyName){
        List<JobResponseDTO> byCompanyName = jobService.getByCompanyName(CompanyName);
        return ResponseEntity.ok().body(byCompanyName);
    }




}
