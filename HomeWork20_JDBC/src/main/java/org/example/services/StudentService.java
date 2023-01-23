package org.example.services;

import org.example.dto.Student;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface StudentService {

    void addStudent(Statement statement, String sqlQuery) throws SQLException;

    void deleteStudent(Statement statement, int StudentId) throws SQLException;

    List<Student> getAll(Statement statement) throws SQLException;

    List<Student> getByName(Statement statement, String name) throws SQLException;

    List<Student> getById(Statement statement, int Id) throws SQLException;
}
