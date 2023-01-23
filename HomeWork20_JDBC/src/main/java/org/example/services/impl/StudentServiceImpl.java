package org.example.services.impl;

import org.example.dto.Student;
import org.example.services.StudentService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public void addStudent(Statement statement, String FullName) throws SQLException {
        statement.execute("insert into students (FullName) VALUES ('" + FullName + "')");

    }

    @Override
    public void deleteStudent(Statement statement, int StudentId) throws SQLException {
        statement.execute("delete from students where StudentId = " + StudentId);
    }

    @Override
    public List<Student> getAll(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from students");
        List<Student> student = new ArrayList<>();
        while (resultSet.next()) {
            int StudentId = resultSet.getInt("StudentId");
            String FullName = resultSet.getString("FullName");
            int StudentGroup = resultSet.getInt("StudentGroup");
            int AdmissionYear = resultSet.getInt("AdmissionYear");
            student.add(new Student(StudentId, FullName, StudentGroup, AdmissionYear));
        }
        System.out.println(student.size());
        System.out.println("----------");

        for (Student s : student)
            System.out.println(s);
        return student;
    }

    @Override
    public List<Student> getByName(Statement statement, String name) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from students where FullName = " + name);
        List<Student> student = new ArrayList<>();
        while (resultSet.next()) {
            int StudentId = resultSet.getInt("StudentId");
            String FullName = resultSet.getString("FullName");
            int StudentGroup = resultSet.getInt("StudentGroup");
            int AdmissionYear = resultSet.getInt("AdmissionYear");
            student.add(new Student(StudentId, FullName, StudentGroup, AdmissionYear));
        }
        System.out.println(student.size());
        System.out.println("----------");

        for (Student s : student)
            System.out.println(s);
        return student;
    }

    @Override
    public List<Student> getById(Statement statement, int Id) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from students where StudentId = " + Id);
        List<Student> student = new ArrayList<>();
        while (resultSet.next()) {
            int StudentId = resultSet.getInt("StudentId");
            String FullName = resultSet.getString("FullName");
            int StudentGroup = resultSet.getInt("StudentGroup");
            int AdmissionYear = resultSet.getInt("AdmissionYear");
            student.add(new Student(StudentId, FullName, StudentGroup, AdmissionYear));
        }
        System.out.println(student.size());
        System.out.println("----------");

        for (Student s : student)
            System.out.println(s);
        return student;
    }


}
