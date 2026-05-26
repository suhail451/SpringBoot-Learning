package org.example.Service.StudentService;

import org.example.DB.Students;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class StudentDeleteService implements StudentCURDService{
    @Override
    public void doOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID : ");
        int userId =  sc.nextInt();
        sc.nextLine();
        Students student = session.find(Students.class, userId);
        if(student == null){
            System.out.println("No Any Student Is Found Here With Student ID : "+ userId +"!");
            session.close();
            return;
        }

        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            session.remove(student);
            transaction.commit();
            System.out.println("Student Deleted Successfully");
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
