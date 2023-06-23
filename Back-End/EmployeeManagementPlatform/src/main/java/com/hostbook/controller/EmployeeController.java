package com.hostbook.controller;

import com.hostbook.model.Employee;
import com.hostbook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/")
    public ResponseEntity<?> listOfEmployees(){
        return employeeService.listOfEmployees();
    }

    @PutMapping("/edit")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee, @RequestParam("id") int employeeId){
        return employeeService.updateEmployee(employee,employeeId);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestParam("id") int employeeId){
        return employeeService.deleteEmployee(employeeId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewEmployee(@PathVariable("id") int employeeId){
        return employeeService.viewEmployee(employeeId);
    }
}
