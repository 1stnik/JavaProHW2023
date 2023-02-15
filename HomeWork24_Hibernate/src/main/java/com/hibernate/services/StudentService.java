package com.hibernate.services;

import com.hibernate.dto.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    void addStudent(Student student) throws Exception;

    List<Student> getAll() throws Exception;

    List<Student> getByName(String name) throws Exception;

    Student getById(int id) throws Exception;
}
