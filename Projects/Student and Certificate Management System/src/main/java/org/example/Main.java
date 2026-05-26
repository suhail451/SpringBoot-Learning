package org.example;

import org.example.Service.CertificationService.Certificate;
import org.example.Service.CertificationService.CreateCertificateService;
import org.example.Service.CertificationService.DeleteCertificateService;
import org.example.Service.CertificationService.ShowCertificates;
import org.example.Service.StudentService.*;

import java.util.Scanner;

public class Main {
    static StudentService studentService;
    static Certificate certificate;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1 => Create Student");
            System.out.println("2 => Show All Students Data");
            System.out.println("3 => Update Student");
            System.out.println("4 => Search Student");
            System.out.println("5 => Delete Student");
            System.out.println("6 => Show Paginated Data");
            System.out.println("7 => Create Certificate");
            System.out.println("8 => Show Certificates");
            System.out.println("9 => Delete Certificate");
            System.out.println("0 => Exit");
            System.out.print("Enter Your Choice : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1  -> CreateInMain();
                case 2 -> ReadAllInMain();
                case 3 -> update();
                case 4 -> searchStudent();
                case 5 -> deleteStudent();
                case 6 -> ShowStudentPages();
                case 7 -> createCertificate();
                case 8 -> showCertificate();
                case 9 -> deleteCertficate();
                case 0 ->{
                    System.out.println("Thank you For Using Student Management System");
                    System.exit(0);
                }
                default -> System.out.println("Please Enter Correct Option ReTry");
            }
        }
    }

    private static void ShowStudentPages() {
        studentService = new StudentService(new StudentPagination());
        studentService.doWork();
    }

    public static void CreateInMain(){
        studentService = new StudentService(new StudentCreateService());
//        studentService.Create();
        studentService.doWork();
    }

    public static void ReadAllInMain(){
        studentService = new StudentService(new StudentReadService());
//        studentService.ShowAllRecord();
        studentService.doWork();
    }

    public static  void update(){
        studentService = new StudentService(new StudentUpdateService());
//        studentService.Update();
        studentService.doWork();
    }

    public static void searchStudent(){
        studentService = new StudentService(new StudentFindService());
//        studentService.SearchStudent();
        studentService.doWork();
    }

    public static void deleteStudent(){
        studentService = new StudentService(new StudentDeleteService());
//        studentService.deleteStudent();
        studentService.doWork();
    }

    public static void createCertificate(){
        certificate = new Certificate(new CreateCertificateService());
        certificate.doWork();
    }

    public static void showCertificate(){
        certificate = new Certificate((new ShowCertificates()));
        certificate.doWork();
    }

    public static void deleteCertficate(){
        certificate = new Certificate((new DeleteCertificateService()));
        certificate.doWork();
    }
}