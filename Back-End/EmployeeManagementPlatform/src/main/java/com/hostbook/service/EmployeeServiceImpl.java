package com.hostbook.service;

import com.hostbook.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Override
    public ResponseEntity<?> createEmployee(Employee employee) {
        return null;
    }

    @Override
    public ResponseEntity<?> listOfEmployees() {
        return null;
    }

    @Override
    public ResponseEntity<?> updateEmployee(Employee employee, int employeeId) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteEmployee(int employeeId) {
        return null;
    }

    @Override
    public ResponseEntity<?> viewEmployee(int employeeId) {
        return null;
    }
}
