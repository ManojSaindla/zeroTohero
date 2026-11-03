package com.employee.employee_management.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.employee_management.entity.Employee;
import com.employee.employee_management.service.EmployeeService;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import com.employee.employee_management.dto.EmployeeRequest;


@RestController
@RequestMapping ("/api/employees")
public class EmployeeController {

    public final EmployeeService employeeService;

    // Constructor injection for EmployeeService
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

@GetMapping ("/hello")
public String hello(){
    return "Employee details";
}

@GetMapping 
public List<Employee> getAllEmployee(){
    return employeeService.getAllEmployees();
}

@GetMapping("/{id}") 
public Employee getEmployeeById(@PathVariable Long id){
    return employeeService.getEmployeeById(id);
}
    
@PostMapping
public Employee createEmployee(@RequestBody EmployeeRequest request){
    return employeeService.createEmployee(request);
}

@PutMapping("/{id}")
public Employee updatedEmployee(@PathVariable Long id, @RequestBody Employee employee){
    return employeeService.updateEmployee(id, employee);

}

@DeleteMapping("/{id}")
public String deleteEmployee(@PathVariable Long id){
    employeeService.deleteEmployee(id);
    return "Employee deleted successfully with id: " + id;
}

}