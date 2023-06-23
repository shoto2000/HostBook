package com.hostbook.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;
    @NotNull(message = "First Name must not be null")
    private String employeeFirstName;
    @NotNull(message = "Email Name must not be null")
    private String employeeLastName;
    @Email(message = "Format of Email is incorrect")
    @NotNull(message = "Email must not be null")
    private String employeeEmailId;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
