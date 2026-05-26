package org.example.Service.StudentService;

import org.example.DB.Students;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class StudentFindService implements StudentCURDService{

    @Override
    public void doOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your user Id : ");
        int userId = sc.nextInt();
        sc.nextLine();
        Students student = session.find(Students.class, userId);
        if(student == null){
            System.out.println("No Any Student Is Found Here With Student ID : "+userId+"!");
            session.close();
            return;
        }
        System.out.println("<<<<<>>>>> Your Data <<<<<>>>>>");
        System.out.println("Student Id : *********:> "+ student.getStudent_Id());
        System.out.println("Name : ***************:> "+ student.getName());
        System.out.println("Father Name : ********:> "+ student.getFatherName());
        System.out.println("Education : **********:> "+ student.getEducation());
        System.out.println("Religion : ***********:> "+ student.getReligion());
        System.out.println("Caste : **************:> "+ student.getCaste());
        System.out.println("About : **************:> "+ student.getAbout());
        System.out.println("Address : ************:> "+ student.getAddress());
    }
}
