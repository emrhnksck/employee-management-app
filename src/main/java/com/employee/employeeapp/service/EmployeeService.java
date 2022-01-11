package com.employee.employeeapp.service;

import com.employee.employeeapp.exception.ResourceNotFoundException;
import com.employee.employeeapp.model.Employee;
import com.employee.employeeapp.repository.EmployeeRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee createEmplyee(Employee employee){
        return employeeRepository.save(employee);
    }

    public ResponseEntity<Employee> getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee doesn't exist: " + id));
        return ResponseEntity.ok(employee) ;
    }

    public ResponseEntity<Employee> updateEmplloyee(Long id,Employee newEmployee){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee doesn't exist: " + id));
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setEmailId(newEmployee.getEmailId());

        employeeRepository.save(employee);

        return ResponseEntity.ok(employee);
    }

    public ResponseEntity<Void> deleteEmployee(Long id){
        employeeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
