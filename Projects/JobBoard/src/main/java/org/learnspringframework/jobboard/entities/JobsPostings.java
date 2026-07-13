package org.learnspringframework.jobboard.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Jobs")
public class JobsPostings {

//    id           Long
//    title        String
//    companyName  String
//    location     String
//    salaryRange  String     (e.g. "80k-120k")
//    jobType      String     (Full-time / Part-time / Remote)
//    postedDate   LocalDate
//    isActive     boolean

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Job_title" , nullable = false)
    private String title;

    @Column(name = "Job_Description" , nullable = false, length = 1000)
    private String jobDescription;

    @Column(name = "Company_Name" , nullable = false)
    private String companyName;

    @Column(name = "Location")
    private String location;

    @Column(name = "Salary_Range")
    private String salaryRange;

    @Column(name = "Job_Type")
    private String jobType;

    @Column(name = "Posted_Date")
    private LocalDate postedDate;

    @Column(name = "is_Active")
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

    public JobsPostings() {

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
