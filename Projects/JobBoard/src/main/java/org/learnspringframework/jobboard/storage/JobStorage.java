package org.learnspringframework.jobboard.storage;

import org.learnspringframework.jobboard.Data.JobsPostings;
import org.learnspringframework.jobboard.exceptions.JobNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class JobStorage {

    private static List<JobsPostings> job = new ArrayList<>();

    private static Long idjob = 0l;

    static {
        job.add(new JobsPostings(++idjob, "Java Developer", "Need a Java Developer with strong Data Structures and Backend knowledge of Spring Boot", "SoftNations", "Karachi", "40k-70k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Backend Java Developer", "Looking for a Backend Java Developer with Spring Boot and REST API experience", "TechNova", "Karachi", "50k-80k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Spring Boot Developer", "Need Spring Boot Developer with knowledge of MySQL, Hibernate, and REST APIs", "CodeWorks", "Lahore", "60k-90k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Software Engineer", "Required Java Software Engineer with OOP, problem solving, and backend development skills", "DevHouse", "Islamabad", "70k-120k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Junior Java Developer", "Fresh Java Developer needed with basic knowledge of Java, JDBC, SQL, and Collections", "SoftTech", "Hyderabad", "35k-55k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Backend Engineer", "Need Java Backend Engineer with Spring Boot, JPA, and RESTful services knowledge", "NextGen Systems", "Karachi", "80k-130k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Full Stack Java Developer", "Looking for Full Stack Java Developer with React frontend and Spring Boot backend experience", "WebSoft", "Lahore", "90k-150k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Intern", "Java Intern required with basic programming concepts, OOP, and database understanding", "BrightCode", "Karachi", "20k-35k", "Internship", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "REST API Developer", "Need REST API Developer with Java, Spring Boot, Postman, and JSON handling skills", "API Solutions", "Islamabad", "60k-100k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Hibernate Developer", "Required Hibernate Developer with strong ORM, entity mapping, and SQL query knowledge", "DataSoft", "Multan", "55k-85k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Microservices Developer", "Need developer with Java, Spring Boot, Microservices architecture, and API gateway knowledge", "CloudCore", "Karachi", "100k-180k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Core Java Developer", "Looking for Core Java Developer with strong OOP, Collections Framework, and exception handling knowledge", "LogicWare", "Lahore", "45k-75k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Web Developer", "Need Java Web Developer with JSP, Servlets, MySQL, and MVC architecture knowledge", "WebBridge", "Faisalabad", "45k-70k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Spring MVC Developer", "Required Spring MVC Developer with backend development and controller-service-layer experience", "AppMakers", "Karachi", "65k-95k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Application Developer", "Need Java Application Developer for business software development and backend module implementation", "BusinessSoft", "Islamabad", "70k-110k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Backend Developer", "Looking for Backend Developer with Java, SQL, REST APIs, and API integration knowledge", "ServerSide Tech", "Lahore", "60k-100k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Developer Trainee", "Java trainee required with basic DSA, OOP, database, and Git knowledge", "CodeAcademy", "Karachi", "25k-40k", "Trainee", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Enterprise Java Developer", "Need Enterprise Java Developer with Spring Boot, Maven, layered architecture, and database experience", "Enterprise Logic", "Islamabad", "90k-160k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Cloud Developer", "Required Java Developer with AWS basics, Spring Boot deployment, and cloud database knowledge", "CloudSoft", "Karachi", "100k-170k", "Remote", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java API Integration Developer", "Need developer for third-party API integration using Java, Spring Boot, and JSON parsing", "IntegrateX", "Lahore", "70k-120k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Database Developer", "Looking for Java Developer with strong SQL, JDBC, database design, and query optimization skills", "DB Experts", "Hyderabad", "50k-85k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Spring Security Developer", "Need developer with Java, Spring Security, JWT authentication, and role-based authorization knowledge", "SecureApps", "Karachi", "90k-140k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java E-Commerce Developer", "Required Java Developer for e-commerce backend using Spring Boot, payment APIs, and MySQL", "ShopTech", "Lahore", "80k-130k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Developer", "Need Java Developer with knowledge of Git, Maven, REST APIs, and basic Spring Boot", "TechStack", "Islamabad", "55k-90k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Backend Intern", "Backend intern required with Java, Spring Boot basics, MySQL, and REST API understanding", "InternSoft", "Karachi", "20k-30k", "Internship", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Spring Boot REST Developer", "Need REST Developer with Spring Boot, JPA, validation, and exception handling knowledge", "Restify Tech", "Lahore", "65k-105k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java FinTech Developer", "Required Java Developer for financial application backend development and secure transaction modules", "FinSoft", "Karachi", "100k-180k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Developer Remote", "Looking for remote Java Developer with Spring Boot, PostgreSQL, and GitHub workflow experience", "RemoteCode", "Remote", "70k-120k", "Remote", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Support Developer", "Need Java Support Developer for bug fixing, backend maintenance, and production issue handling", "SupportSoft", "Islamabad", "45k-70k", "Part-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java QA Automation Engineer", "Need QA Automation Engineer with Java, Selenium, testing concepts, and automation scripts knowledge", "QualityTech", "Lahore", "60k-100k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Android Java Developer", "Required Android Developer with Java, Firebase, API integration, and mobile UI knowledge", "MobileMinds", "Karachi", "50k-90k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Desktop App Developer", "Need Java Developer with Swing, JavaFX, file handling, and database connectivity knowledge", "DesktopSoft", "Faisalabad", "45k-75k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Banking Software Developer", "Looking for Java Developer for banking application modules, secure APIs, and transaction handling", "BankSoft", "Karachi", "120k-200k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Developer Fresh Graduate", "Fresh graduate required with Java, OOP, basic DSA, and database concepts", "FreshTech", "Lahore", "30k-50k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java System Developer", "Need Java System Developer with multithreading, file handling, and backend logic knowledge", "SystemSoft", "Islamabad", "70k-110k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Developer with Docker", "Required Java Developer with Spring Boot, Docker basics, and deployment knowledge", "ContainerTech", "Karachi", "90k-150k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java CRM Developer", "Need Java Developer to work on CRM backend modules, customer records, and reporting APIs", "CRM Solutions", "Lahore", "65k-100k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java ERP Developer", "Looking for Java Developer with ERP system, database workflow, and business module knowledge", "ERPSoft", "Karachi", "80k-140k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Developer Night Shift", "Need Java Backend Developer for night shift support, backend development, and bug fixing", "NightCode", "Remote", "60k-95k", "Remote", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Spring Boot Junior Engineer", "Required Junior Engineer with Spring Boot, REST API, MySQL, and validation knowledge", "BootLabs", "Islamabad", "50k-80k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Healthcare Developer", "Need Java Developer for healthcare management software, patient records, and secure APIs", "MediSoft", "Karachi", "90k-160k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Education App Developer", "Looking for Java Developer for LMS backend, student records, and course management APIs", "EduTech", "Lahore", "70k-120k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Logistics Developer", "Need Java Developer for logistics, shipment tracking, inventory flow, and reporting backend", "ShipTech", "Karachi", "80k-130k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Developer with PostgreSQL", "Required Java Developer with PostgreSQL, Spring Data JPA, and query optimization knowledge", "PostgresSoft", "Islamabad", "75k-125k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Security Engineer", "Need Java Security Engineer with authentication, authorization, JWT, and secure coding skills", "CyberApps", "Lahore", "110k-190k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Developer with React", "Looking for Java Developer with React frontend, Spring Boot backend, and REST API integration experience", "FullStack Labs", "Karachi", "90k-150k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Developer Part Time", "Need part-time Java Developer for backend tasks, small API features, and bug fixing", "PartTimeSoft", "Remote", "30k-60k", "Part-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Developer for Startup", "Startup needs Java Developer with fast learning, problem solving, and Spring Boot basics", "StartupHub", "Karachi", "50k-90k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Java Product Developer", "Required Java Product Developer to build scalable SaaS backend modules and REST APIs", "SaaSWorks", "Lahore", "100k-170k", "Full-time", LocalDate.now(), true));
        job.add(new JobsPostings(++idjob, "Senior Java Developer", "Need Senior Java Developer with Spring Boot, Microservices, system design, and database optimization knowledge", "MegaSoft", "Islamabad", "180k-300k", "Full-time", LocalDate.now(), true));

    }


    public static List<JobsPostings> getAllJobs() {
        return job;
    }

    public static JobsPostings updateJob(long id, JobsPostings jobsPostings) {
        JobsPostings jobsPostings1 = job.stream()
                .filter(job -> job.getId() != null && job.getId().equals(id))
                .findFirst()
                .orElseThrow( () -> new JobNotFoundException("Job Not Found by "+ id ));

        jobsPostings1.setId(id);

//        System.out.println(job.indexOf(jobsPostings1));
        job.add(job.indexOf(jobsPostings1), jobsPostings);
        return job.get(job.indexOf(jobsPostings1));
    }


    public JobsPostings save(JobsPostings newJob) {
        newJob.setId(++idjob);
        job.add(newJob);
        return newJob;
    }

    public Optional<JobsPostings> getById(Long id) {
        return Optional.of(job.stream().filter(jobs -> jobs.getId() != null && jobs.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new JobNotFoundException("Job Not Found By Id : " + id)));
    }

    public void delete(JobsPostings jobsPosting) {
        job.remove(jobsPosting);
    }
}
