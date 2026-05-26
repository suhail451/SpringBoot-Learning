package org.example.Service.StudentService;

public class StudentService {

    private final StudentCURDService studentCURDService;


//    CDI
public StudentService(StudentCURDService studentCURDService){
        this.studentCURDService = studentCURDService;
    }

    // we Can Use This For all Operations
    public void doWork(){
        studentCURDService.doOperation();
    }



//    public void Create(){
//        studentCURDService.doOperation();
//    }
//
//    public void ShowAllRecord(){
//        studentCURDService.doOperation();
//    }
//
//    public void Update(){
//        studentCURDService.doOperation();
//    }
//
//    public void SearchStudent(){
//        studentCURDService.doOperation();
//    }
//
//    public void deleteStudent(){
//        studentCURDService.doOperation();
//    }


}
