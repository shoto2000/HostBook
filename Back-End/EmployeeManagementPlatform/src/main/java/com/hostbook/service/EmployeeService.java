package com.hostbook.service;

import com.hostbook.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    public ResponseEntity<Employee> createEmployee(Employee employee);

    public ResponseEntity<List<Employee>> listOfEmployees();

    public ResponseEntity<Employee> updateEmployee(Employee employee, int employeeId);

    public ResponseEntity<?> deleteEmployee(int employeeId);

    public ResponseEntity<Employee> viewEmployee(int employeeId);
}
