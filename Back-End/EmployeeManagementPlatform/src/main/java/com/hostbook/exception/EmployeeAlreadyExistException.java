package com.hostbook.exception;

public class EmployeeAlreadyExistException extends RuntimeException{
    public EmployeeAlreadyExistException(){}
    public EmployeeAlreadyExistException(String message){super(message);}
    public EmployeeAlreadyExistException(String message,Throwable cause){super(message,cause);}
}
