package org.example.Service.StudentService;

import org.example.DB.Students;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class StudentUpdateService implements StudentCURDService{
    @Override
    public void doOperation() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID To Update : ");
        int userId = sc.nextInt();
        sc.nextLine();
        Students Obj1 = session.find(Students.class, userId);
        if(Obj1 == null){
            System.out.println("No Any Student Is Found Here With Student ID : "+ userId +"!");
            session.close();
            return;
        }
        System.out.println("<<<<<>>>>> Your Data <<<<<>>>>>");
        System.out.println("Name : ***************:> "+ Obj1.getName());
        System.out.println("Father Name : ********:> "+ Obj1.getFatherName());
        System.out.println("Education : **********:> "+ Obj1.getEducation());
        System.out.println("Religion : ***********:> "+ Obj1.getReligion());
        System.out.println("Caste : **************:> "+ Obj1.getCaste());
        System.out.println("About : **************:> "+ Obj1.getAbout());
        System.out.println("Address : ************:> "+ Obj1.getAddress());
        System.out.println();
        boolean running = true;
        while (running) {
            System.out.println("***Select What You Want To Update***");
            System.out.println("1 : Name");
            System.out.println("2 : Father Name");
            System.out.println("3 : Education");
            System.out.println("4 : Religion");
            System.out.println("5 : Caste");
            System.out.println("6 : About");
            System.out.println("7 : Address");
            System.out.println("0 : exit");
            System.out.print("ENTER YOUR CHOICE :  ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1 -> {
                    String newName = "";
                    while (newName.isEmpty()){
                        System.out.print("Enter Your Name : ");
                        newName = sc.nextLine().trim();
                    }
                    Obj1.setName(newName);
                }
                case 2 -> {
                    String newFatherName = "";
                    while (newFatherName.isEmpty()){
                        System.out.print("Enter Your Father Name : ");
                        newFatherName = sc.nextLine().trim();
                    }
                    Obj1.setFatherName(newFatherName);
                }
                case 3 -> {
                    String newEducation = "";
                    while (newEducation.isEmpty()){
                        System.out.print("Enter Your Education : ");
                        newEducation = sc.nextLine().trim();
                    }
                    Obj1.setEducation(newEducation);
                }
                case 4 -> {
                    String newReligion = "";
                    while (newReligion.isEmpty()){
                        System.out.print("Enter Your Religion : ");
                        newReligion = sc.nextLine().trim();
                    }
                    Obj1.setReligion(newReligion);
                }
                case 5 -> {
                    String newCaste = "";
                    while(newCaste.isEmpty()){
                        System.out.print("Enter Your Caste : ");
                        newCaste = sc.nextLine().trim();
                    }
                    Obj1.setCaste(newCaste);
                }
                case 6 -> {
                    String newAbout = "";
                    while(newAbout.isEmpty()){
                        System.out.print("Enter Your About : ");
                        newAbout = sc.nextLine().trim();
                    }
                    Obj1.setAbout(newAbout);

                }
                case 7 -> {
                    String newAddress = "";
                    while(newAddress.isEmpty()){
                        System.out.print("Enter Your Address : ");
                        newAddress = sc.nextLine().trim();
                    }
                    Obj1.setAddress(newAddress);

                }
                case 0 -> {
                    running = false;
                }
                default -> System.out.print("Please Enter Correct Choice : ");
            }

        }
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.merge(Obj1);
            transaction.commit();
            System.out.println("Student Updated Successfully");

        } catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
