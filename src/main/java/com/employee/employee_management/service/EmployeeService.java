package com.employee.employee_management.service;
import com.employee.employee_management.entity.Employee;

import org.springframework.stereotype.Service;
import com.employee.employee_management.repository.EmployeeRepository;
import java.util.List;
import com.employee.employee_management.dto.EmployeeRequest;


@Service 
public class EmployeeService {

    private final EmployeeRepository employeeRepository;



    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    public Employee createEmployee(EmployeeRequest request){
        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary()); 
        
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){

        return employeeRepository.findById(id).
        orElseThrow(() -> 
        new RuntimeException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee){

        Employee existingEmployee = employeeRepository.findById(id)
        .orElseThrow(() -> 
        new RuntimeException("Employee not found with id: " + id)); 

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setSalary(updatedEmployee.getSalary());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id){
        Employee existingEmployee = employeeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employeeRepository.delete(existingEmployee);
    }
}
