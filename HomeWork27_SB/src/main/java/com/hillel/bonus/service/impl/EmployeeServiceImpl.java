package com.hillel.bonus.service.impl;

import com.hillel.bonus.service.EmployeeService;
import com.hillel.bonus.entity.Employee;
import com.hillel.bonus.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;


    @Override
    public void addEmployee(Employee employee) {
            employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll().stream().toList();
    }
}
