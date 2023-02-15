package com.hibernate.services.impl;

import com.hibernate.dto.Student;
import com.hibernate.services.StudentService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;


public class StudentServiceImpl implements StudentService {


    @Override
    public void addStudent(Student student) {
        Session session = SessionService.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Student's added");
        } catch (Exception e) {
            System.err.println("AddStudent Exception: " + e);
        }
    }

    @Override
    public List<Student> getAll() {
        Session session = SessionService.getSessionFactory().openSession();
        List<Student> students = new ArrayList<>();
        try {
            String sql = "FROM " + Student.class.getSimpleName();
            students = session.createQuery(sql).list();
            for (Student s : students) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.err.println("GetAll Exception: " + e);
        }
        return students;
    }

    @Override
    public List<Student> getByName(String name) {
        Session session = SessionService.getSessionFactory().openSession();
        List<Student> students = new ArrayList<>();
        try {
            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("FullName", name));
            students = criteria.list();
            for (Student s : students) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.err.println("GetByName Exception: " + e);
        }
        return students;
    }

    @Override
    public Student getById(int id) {
        Session session = SessionService.getSessionFactory().openSession();
        Student student;
        try {
            session.beginTransaction();
            student = (Student) session.get(Student.class, id);
            System.out.println(student);
            return student;
        } catch (Exception e) {
            System.err.println("GetById Exception: " + e);
        }
        return new Student(0, "Empty student");
    }

}
