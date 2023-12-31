package com.hostbook.service;

import com.hostbook.exception.EmployeeAlreadyExistException;
import com.hostbook.exception.EmployeeNotFoundException;
import com.hostbook.model.Employee;
import com.hostbook.repository.EmployeeRepository;
import com.hostbook.response.DeleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<Employee> createEmployee(Employee employee) {
        Optional<Employee> employeeExist = employeeRepository.findByEmployeeEmailId(employee.getEmployeeEmailId());

        if(!employeeExist.isPresent()){
            employee.setCreatedTime(LocalDateTime.now());
            employee.setUpdatedTime(LocalDateTime.now());
            return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
        }

        throw new EmployeeAlreadyExistException("Email id already registered");
    }

    @Override
    public ResponseEntity<List<Employee>> listOfEmployees() {
        return new ResponseEntity<>(employeeRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(Employee employee, int employeeId) {
        Optional<Employee> employeeExist = employeeRepository.findById(employeeId);

        if(employeeExist.isPresent()){
            employee.setEmployeeId(employeeExist.get().getEmployeeId());
            employee.setCreatedTime(employeeExist.get().getCreatedTime());
            employee.setUpdatedTime(LocalDateTime.now());
            return new ResponseEntity<>(employeeRepository.save(employee),HttpStatus.OK);
        }

        throw new EmployeeNotFoundException("Employee does not Exist");
    }

    @Override
    public ResponseEntity<?> deleteEmployee(int employeeId) {
        Optional<Employee> employeeExist = employeeRepository.findById(employeeId);

        if(employeeExist.isPresent()){
            employeeRepository.delete(employeeExist.get());
            return new ResponseEntity<>(new DeleteResponse("Employee"),HttpStatus.OK);
        }

        throw new EmployeeNotFoundException("Employee does not Exist");
    }

    @Override
    public ResponseEntity<Employee> viewEmployee(int employeeId) {
        Optional<Employee> employeeExist = employeeRepository.findById(employeeId);

        if(employeeExist.isPresent()){
            return new ResponseEntity<>(employeeExist.get(),HttpStatus.OK);
        }

        throw new EmployeeNotFoundException("Employee does not Exist");
    }
}
