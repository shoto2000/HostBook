package com.hostbook.service;

import com.hostbook.model.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    public ResponseEntity<?> createEmployee(Employee employee);

    public ResponseEntity<?> listOfEmployees();

    public ResponseEntity<?> updateEmployee(Employee employee, int employeeId);

    public ResponseEntity<?> deleteEmployee(int employeeId);

    public ResponseEntity<?> viewEmployee(int employeeId);
}
