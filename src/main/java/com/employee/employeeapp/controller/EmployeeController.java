package com.employee.employeeapp.controller;

import com.employee.employeeapp.model.Employee;
import com.employee.employeeapp.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAll();
    }

    @PostMapping("/employees/add")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmplyee(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employees/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmplloyee(id,employee);
    }

    @DeleteMapping("/employees/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}
