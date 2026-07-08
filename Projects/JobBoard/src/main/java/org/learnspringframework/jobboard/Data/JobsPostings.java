package org.learnspringframework.jobboard.Data;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class JobsPostings {

//    id           Long
//    title        String
//    companyName  String
//    location     String
//    salaryRange  String     (e.g. "80k-120k")
//    jobType      String     (Full-time / Part-time / Remote)
//    postedDate   LocalDate
//    isActive     boolean

    private Long id;

    @NotBlank(message = "title Field is Required")
    @Size(min = 2, message = "Title length Should be Greater Than 2")
    private String title;

    @NotBlank(message = "Job Description Field is Required")
    @Size(min = 2, message = "Job Description length Should be Greater Than 2")
    private String jobDescription;

    @NotBlank(message = "Company Name is Required")
    @Size(min = 2, message = "Company name length Should be Greater Than 2")
    private String companyName;

    @NotBlank(message = "Location is Required")
    @Size(min = 2, message = "Location length Should be Greater Than 2")
    private String location;

    @NotBlank(message = "Salary Range is Required")
    @Size(min = 2, message = "Salary Range Should be Greater than 2")
    private String salaryRange;

    @NotBlank(message = "Job Type is Required")
    @Size(min = 2, message = "Job Type length Should be Greater Than 2")
    private String jobType;

//    @NotBlank(message = "Posted Date Is Required")
    @PastOrPresent(message = "Posting date Cannot be The Future date Please add Past Or Present Date In this Field")
    private LocalDate postedDate;

    private Boolean isActive;


    public JobsPostings(Long id, String title, String jobDescription, String companyName, String location, String salaryRange, String jobType, LocalDate postedDate, Boolean isActive) {
        this.id = id;
        this.title = title;
        this.jobDescription = jobDescription;
        this.companyName = companyName;
        this.location = location;
        this.salaryRange = salaryRange;
        this.jobType = jobType;
        this.postedDate = postedDate;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
