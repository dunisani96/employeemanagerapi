package com.dunisani.learning.employeemanagement.service;

import com.dunisani.learning.employeemanagement.exception.UserNotFoundException;
import com.dunisani.learning.employeemanagement.model.Employee;
import com.dunisani.learning.employeemanagement.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public  Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }

    public  Employee findEmployeeById(Long id){

       return  employeeRepository.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException(" User not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }
}
