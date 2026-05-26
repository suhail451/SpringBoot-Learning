package org.example.Service.StudentService;

import org.example.DB.Certification;
import org.example.DB.Students;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Scanner;

public class StudentCreateService implements StudentCURDService{


    @Override
    public void doOperation() {

        Scanner scanner = new Scanner(System.in);

        String Name = "", FatherName = "", Caste = "", Religion = "", Education = "", Address = "", about = "";
        String certificateName = "", company = "", DirectorName = "", Certificate_info = "";

        System.out.print("Enter Your Name : ");
        while(Name.isEmpty() || Name.equals(" "))
            Name = scanner.nextLine().trim();

        System.out.print("Enter Your Father Name : ");
        while(FatherName.isEmpty() || FatherName.equals(" ")) {
            FatherName = scanner.nextLine().trim();
        }


        System.out.print("Enter Your Caste : ");
        while(Caste.isEmpty() || Caste.equals(" ")) {
            Caste = scanner.nextLine().trim();
        }

        System.out.print("Enter Your Religion : ");
        while(Religion.isEmpty() || Religion.equals(" ")) {
            Religion = scanner.nextLine().trim();
        }

        System.out.print("Enter Your Education : ");
        while(Education.isEmpty() || Education.equals(" ")) {
            Education = scanner.nextLine().trim();
        }

        System.out.print("Enter Your Address : ");
        while(Address.isEmpty() || Address.equals(" ")) {
            Address = scanner.nextLine().trim();
        }

        System.out.print("Enter Your About : ");
        while(about.isEmpty() || about.equals(" ")) {
            about = scanner.nextLine().trim();
        }

        Students Std = new Students();
        Std.setName(Name);
        Std.setFatherName(FatherName);
        Std.setCaste(Caste);
        Std.setReligion(Religion);
        Std.setEducation(Education);
        Std.setAddress(Address);
        Std.setAbout(about);
        boolean certficateOp = true;
        while (certficateOp) {
            System.out.print("Did Student Had Certification (Y/N) : ");
            String choice = "";
            while (choice.isEmpty() || choice.equals(" ")) {
                choice = scanner.nextLine().trim();
            }
            // Continue
            if (choice.equalsIgnoreCase("Y")) {
                    System.out.print("Enter Certificate Name : ");
                    while (certificateName.isEmpty() || certificateName.equals(" ")) {
                        certificateName = scanner.nextLine().trim();
                    }

                    System.out.print("Certificate By (Company Name) : ");
                    while (company.isEmpty() || company.equals(" ")) {
                        company = scanner.nextLine().trim();
                    }

                    System.out.print("Enter The Name Of Director of Certificate : ");
                    while (DirectorName.isEmpty() || DirectorName.equals(" ")) {
                        DirectorName = scanner.nextLine().trim();
                    }

                    System.out.print("Certificate Info : ");
                    while (Certificate_info.isEmpty() || Certificate_info.equals(" ")) {
                        Certificate_info = scanner.nextLine().trim();
                    }
                    Certification certificate = new Certification();
                    certificate.setStudents(Std);
                    certificate.setCertificate_Name(certificateName);
                    certificate.setCompany(company);
                    certificate.setDirectorName(DirectorName);
                    certificate.setCertificate_info(Certificate_info);
                    LocalDate today = LocalDate.now();
                    certificate.setDate(today);
                    Std.getCertificationList().add(certificate);
                    certificateName = "";
                    company = "";
                    DirectorName = "";
                    Certificate_info = "";
                    System.out.println("Certification Added To list");
            } else if (choice.equalsIgnoreCase("N")) {
                certficateOp = false;
            } else {
                System.out.println("invalid Choice");
            }
        }





      SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();
      Session ses = sessionFactory.openSession();

        Transaction tx = null;
        try{
            tx = ses.beginTransaction();
            ses.persist(Std);
            tx.commit();
            System.out.println("Student Saved Successfully");
        }catch (Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            ses.close();
        }
    }
}
