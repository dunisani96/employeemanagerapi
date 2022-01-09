package com.dunisani.learning.employeemanagement.controller;


import com.dunisani.learning.employeemanagement.model.Employee;
import com.dunisani.learning.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private  final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
       List<Employee> employees= employeeService.getAllEmployees();

       return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee= employeeService.addEmployee(employee);

        return  new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public  ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long id){
        Employee employee= employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PutMapping("/update")
    public  ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee newEmployee= employeeService.updateEmployee(employee);

        return  new ResponseEntity<>(newEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteById(@PathVariable("id") long id ){
        employeeService.deleteEmployee(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
