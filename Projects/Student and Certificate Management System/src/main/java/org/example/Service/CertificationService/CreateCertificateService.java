package org.example.Service.CertificationService;

import org.example.DB.Certification;
import org.example.DB.Students;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Scanner;

public class CreateCertificateService implements CertificationService{
    @Override
    public void doWork() {
        String certificateName = "", company = "", DirectorName = "", Certificate_info = "";

        Students std = null;
        Scanner sc = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()){

            System.out.print("Enter Student Id : ");
            int stdentId = sc.nextInt();
            sc.nextLine();
             std = session.find(Students.class, stdentId);
            if(std == null){
                System.out.println("No Any Student Found With This Id!");
                return;
            }
            System.out.print("Enter Certificate Name : ");
            while (certificateName.isEmpty() || certificateName.equals(" ")) {
                certificateName = sc.nextLine().trim();
            }
            System.out.print("Certificate By (Company Name) : ");
            while (company.isEmpty() || company.equals(" ")) {
                company = sc.nextLine().trim();
            }

            System.out.print("Enter The Name Of Director of Certificate : ");
            while (DirectorName.isEmpty() || DirectorName.equals(" ")) {
                DirectorName = sc.nextLine().trim();
            }

            System.out.print("Certificate Info : ");
            while (Certificate_info.isEmpty() || Certificate_info.equals(" ")) {
                Certificate_info = sc.nextLine().trim();
            }
            Certification certificate = new Certification();
            certificate.setStudents(std);
            certificate.setCertificate_Name(certificateName);
            certificate.setCompany(company);
            certificate.setDirectorName(DirectorName);
            certificate.setCertificate_info(Certificate_info);
            LocalDate today = LocalDate.now();
            certificate.setDate(today);
            tx = session.beginTransaction();
            session.persist(certificate);
            tx.commit();

        } catch (Exception e) {
            if(std != null) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        }

    }
}
