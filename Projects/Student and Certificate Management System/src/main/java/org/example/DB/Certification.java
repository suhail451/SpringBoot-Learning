package org.example.DB;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name= "student_certification")
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Certificate_Id;

    private String Certificate_Name;

    private LocalDate date;

    private String company;

    private String DirectorName;

    @Lob
    private String Certificate_info;

    @ManyToOne
    @JoinColumn(name="Student_Id")
    private Students students;

    public int getCertificate_Id() {
        return Certificate_Id;
    }

    public void setCertificate_Id(int certificate_Id) {
        Certificate_Id = certificate_Id;
    }

    public String getCertificate_Name() {
        return Certificate_Name;
    }

    public void setCertificate_Name(String certificate_Name) {
        Certificate_Name = certificate_Name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDirectorName() {
        return DirectorName;
    }

    public void setDirectorName(String directorName) {
        DirectorName = directorName;
    }

    public String getCertificate_info() {
        return Certificate_info;
    }

    public void setCertificate_info(String certificate_info) {
        Certificate_info = certificate_info;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }
}
