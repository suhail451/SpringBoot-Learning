package org.learnspringframework.jobboard.service;

import org.learnspringframework.jobboard.Data.JobsPostings;
import org.learnspringframework.jobboard.storage.JobStorage;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class JobService {

    private JobStorage jobStorage;

    public JobService(JobStorage jobStorage) {
        this.jobStorage = jobStorage;
    }


    public JobsPostings save(JobsPostings newJob) {
        jobStorage.save(newJob);
        return newJob;
    }


    public List<JobsPostings> getAllJobs() {
        return jobStorage.getAllJobs();
    }


    public JobsPostings getById(Long id) {
        return jobStorage.getById(id).orElse(null);
    }


    public List<JobsPostings> getJobsByLocation(String location) {
       return jobStorage.getAllJobs()
                .stream()
                .filter(job -> job.getLocation().equalsIgnoreCase(location))
                .toList();
    }


    public List<JobsPostings> getJobsByType(String type) {
        return jobStorage.getAllJobs()
                .stream()
                .filter(job -> job.getJobType().equalsIgnoreCase(type))
                .toList();
    }

    public List<JobsPostings> getOnlyActiveJobs() {
        return jobStorage.getAllJobs()
                .stream()
                .filter(job -> job.isActive())
                .toList();
    }

    public List<JobsPostings> getJobSorted(String sortBy) {

        if (sortBy.equalsIgnoreCase("postedDate")) {
            return jobStorage.getAllJobs()
                    .stream()
                    .sorted(Comparator.comparing(JobsPostings::getPostedDate).reversed())
                    .toList();
        }

        if(sortBy.equalsIgnoreCase("salary")){
            return jobStorage.getAllJobs()
                    .stream()
                    .sorted(Comparator.comparing( job ->  exactMinsalary(job.getSalaryRange())))
                    .toList();
        }

        if(sortBy.equalsIgnoreCase("salaryHighToLow")){
            return jobStorage.getAllJobs()
                    .stream()
                    .sorted(Comparator.comparing(  (JobsPostings job) ->  exactMinsalary(job.getSalaryRange())).reversed()                    )
                    .toList();
        }

        return jobStorage.getAllJobs();
    }


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
}
