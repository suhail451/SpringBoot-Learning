package org.example.DB;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students_Table")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Student_Id;

    @Column(name = "std_name",length = 100)
    private String Name;

    @Column(name = "std_father_name",length = 100)
    private String FatherName;

    @Column(name = "std_caste",length = 100)
    private String Caste;

    @Column(name = "std_religion", length = 100)
    private String Religion;

    @Column(name = "std_Education")
    private String Education;

    @Column(name = "std_Address")
    private String Address;

    @Lob
    private String about;

    @OneToMany(mappedBy = "students", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certification> certificationList = new ArrayList<>();


    public List<Certification> getCertificationList() {
        return certificationList;
    }

    public void setCertificationList(List<Certification> certificationList) {
        this.certificationList = certificationList;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getStudent_Id() {
        return Student_Id;
    }

    public void setStudent_Id(int student_Id) {
        this.Student_Id = student_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getCaste() {
        return Caste;
    }

    public void setCaste(String caste) {
        Caste = caste;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String religion) {
        Religion = religion;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
