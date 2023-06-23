package com.hostbook.controller;

import com.hostbook.model.Employee;
import com.hostbook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> createEmployee(@RequestBody @Valid Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
                System.out.println(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/")
    public ResponseEntity<?> listOfEmployees(){
        return employeeService.listOfEmployees();
    }

    @PutMapping("/edit")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult, @RequestParam("id") int employeeId) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        return employeeService.updateEmployee(employee, employeeId);
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
