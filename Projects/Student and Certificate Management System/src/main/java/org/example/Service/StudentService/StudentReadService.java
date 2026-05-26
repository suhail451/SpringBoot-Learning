package org.example.Service.StudentService;

import jakarta.persistence.Query;
import org.example.DB.Students;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentReadService implements StudentCURDService{

    @Override
    public void doOperation() {
        String hql = "FROM Students";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session ses = sessionFactory.openSession();
        Query query = ses.createQuery(hql, Students.class);
        List<Students> StudentsList = query.getResultList();
        for(Students Data : StudentsList ){
            System.out.println(" "+ Data.getStudent_Id() + " | "+ Data.getName() + " | "+ Data.getFatherName() + " | "+ Data.getEducation()  +" | "+ Data.getCaste() + " | "+ Data.getReligion() + " | "+ Data.getAddress() + " | "+ Data.getAbout());
        }
        ses.close();


    }
}
