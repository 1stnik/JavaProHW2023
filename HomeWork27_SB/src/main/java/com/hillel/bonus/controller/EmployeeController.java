package com.hillel.bonus.controller;

import com.hillel.bonus.service.EmployeeService;
import com.hillel.bonus.entity.Employee;
import com.hillel.bonus.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Employee addNewEmployee(@RequestBody Employee employee) {
        LOG.info("Save an new employee.");
        return employeeRepository.save(employee);
    }

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Employee> getAllEmployee() {
        List<Employee> listOfAllEmployees = employeeService.getAllEmployees();
        LOG.info("Get all employees. " + "\n" + listOfAllEmployees);
        return listOfAllEmployees;
    }
}
