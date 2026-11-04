package com.employee.employee_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class EmployeeRequest {
	

	@NotBlank (message="Name should not be empty")
	private String name;
	
	@NotBlank (message="Email should not be empty")
	@Email (message="Email should be valid")
	private String email;

	@Positive (message="Salary should be greater than 0")
	private Double salary;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	

}
