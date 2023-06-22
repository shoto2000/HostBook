package com.hostbook.repository;

import com.hostbook.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public Optional<Employee> findByEmployeeEmailId(String employeeEmailId);
}
