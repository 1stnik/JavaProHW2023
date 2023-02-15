package com.hibernate;

/**
 * @author Serhii Nikonenko
 * @version 1.1.0
 */

import com.hibernate.dto.Student;
import com.hibernate.services.StudentService;
import com.hibernate.services.impl.SessionService;
import com.hibernate.services.impl.StudentServiceImpl;

public class HibernateRun {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello Hibernate!");
        StudentService studentService = new StudentServiceImpl();
        studentService.addStudent(new Student("Dobee", 123, 2001));
        studentService.addStudent(new Student("Garry", 456, 2006));
        studentService.addStudent(new Student("Hermiona", 789, 2007));

        System.out.println("--------------------------------");

        studentService.getByName("Garry");

        System.out.println("--------------------------------");

        studentService.getById(3);
        studentService.getById(1);

        System.out.println("--------------------------------");

        studentService.addStudent(new Student("Ron", 357, 2005));

        System.out.println("--------------------------------");

        studentService.getAll();

        SessionService.shutdown();

    }
}
