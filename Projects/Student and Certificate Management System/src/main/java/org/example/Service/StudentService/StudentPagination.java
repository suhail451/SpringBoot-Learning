package org.example.Service.StudentService;

import org.example.DB.Students;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class StudentPagination implements StudentCURDService{
    @Override
    public void doOperation() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print("Enter Page No : ");
            int page = sc.nextInt();

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            try (Session session = sessionFactory.openSession()) {
                String HQL = "FROM Students";
                Query<Students> query = session.createQuery(HQL, Students.class);
                query.setFirstResult((page - 1) * 5);
                query.setMaxResults(5);
                List<Students> StudentsList = query.getResultList();
//            System.out.println("Student Id \t|\t Student Name \t|\t Student Father Name \t|\t Student Education \t|\t Student Caste \t|\t Student Religion \t|\t Student Address \t|\t Student About");
//            for(Students Data : StudentsList ){
//                System.out.println(" "+ Data.getStudent_Id() + "\t|\t"+ Data.getName() + "\t|\t"+ Data.getFatherName() + "\t|\t"+ Data.getEducation()  +"\t|\t"+ Data.getCaste() + "\t|\t"+ Data.getReligion() + "\t|\t"+ Data.getAddress() + "\t|\t"+ Data.getAbout());
//            }

                System.out.printf("%-10s %-20s %-20s %-15s %-15s %-15s %-30s %-30s%n",
                        "ID", "Name", "Father Name", "Education", "Caste", "Religion", "Address", "About");

                System.out.println("---------------------------------------------------------------------------------------------------------------");

                for (Students data : StudentsList) {
                    System.out.printf("%-10d %-20s %-20s %-15s %-15s %-15s %-30s %-30s%n",
                            data.getStudent_Id(),
                            data.getName(),
                            data.getFatherName(),
                            data.getEducation(),
                            data.getCaste(),
                            data.getReligion(),
                            data.getAddress(),
                            data.getAbout());
                }
                System.out.println("-------------------");
                boolean running = true;
                while(running) {
                    System.out.println("1 => Continue");
                    System.out.println("2 => Back");
                    System.out.print("ENTER YOUR CHOICE : ");
                    int ch = sc.nextInt();
                    if (ch == 1) {
                        running = false;
                        flag = true;
                    } else if (ch == 2) {
                        running = false;
                        flag = false;
                    }else{
                        System.out.println("Invailed Option");
                        running = true;
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }
}
