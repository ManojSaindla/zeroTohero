package com.employee.employee_management.exception;

// Custom exception class for handling employee not found scenarios
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
    
}
