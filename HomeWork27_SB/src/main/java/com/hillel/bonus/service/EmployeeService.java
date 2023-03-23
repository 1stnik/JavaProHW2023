package com.hillel.bonus.service;

import com.hillel.bonus.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();


}
