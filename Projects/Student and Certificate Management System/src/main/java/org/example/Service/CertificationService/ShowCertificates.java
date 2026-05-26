package org.example.Service.CertificationService;

import org.example.DB.Certification;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class ShowCertificates implements CertificationService{

    @Override
    public void doWork() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.print("Enter Page No : ");
            int pageNo = sc.nextInt();
            System.out.print("Enter Page Size : ");
            int pageSize = sc.nextInt();
            List<Certification> certificationList = getPaginatedCertificate(pageNo, pageSize);

            for (int i = 0; i < certificationList.size(); i++) {
                System.out.println("********************************************<<Certificate>>******************************************");
                System.out.println("ID **************:> " + certificationList.get(i).getCertificate_Id() + " | ");
                System.out.println("NAME ************:> " + certificationList.get(i).getCertificate_Name() + " | ");
                System.out.println("COMPANY *********:> " + certificationList.get(i).getCompany() + " | ");
                System.out.println("DIRECTOR ********:> " + certificationList.get(i).getDirectorName() + " | ");
                System.out.println("DATE ************:> " + certificationList.get(i).getDate() + " | ");
                System.out.println("INFO ************:> " + certificationList.get(i).getCertificate_info() + " | ");
                System.out.println("Student Is ******:> " + certificationList.get(i).getStudents().getStudent_Id());
                System.out.println("*****************************************************************************************************");
            }
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

    private static List<Certification> getPaginatedCertificate(int Pageno, int PageSize){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            String hql = "From Certification";
            Query<Certification> query = session.createQuery(hql, Certification.class);
            query.setFirstResult((Pageno-1)*PageSize);
            query.setMaxResults(PageSize);
            return query.list();
        }
    }
}
