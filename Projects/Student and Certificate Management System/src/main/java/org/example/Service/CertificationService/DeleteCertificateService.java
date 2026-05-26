package org.example.Service.CertificationService;

import org.example.DB.Certification;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class DeleteCertificateService implements CertificationService{

    @Override
    public void doWork() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Certificate ID : ");
        int CertificateId = sc.nextInt();
        deleteCertificate(CertificateId);

        boolean flag = true;
        while(flag){
            boolean running = true;
            while (running) {
                System.out.println("1: Continue ");
                System.out.println("2: Manu");
                System.out.print("Do You Want To Continue : ");
                int ch = sc.nextInt();
                if (ch == 1) {
                    flag = true;
                    running = false;
                } else if(ch == 2){
                    flag = false;
                    running = false;
                }else {
                    System.out.print("invalid Choice! Enter Correct Choice : ");
                    running = true;
                }
            }

        }


    }

    private static void deleteCertificate(int certificateId){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction tx = null;

        try(Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            Certification certification = session.find(Certification.class, certificateId);
            session.remove(certification);
            tx.commit();
            System.out.println("Student Deleted Successfully! ");
        }catch (Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
