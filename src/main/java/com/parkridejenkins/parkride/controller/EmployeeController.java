package com.parkridejenkins.parkride.controller;

import com.parkridejenkins.parkride.entity.Employee;
import com.parkridejenkins.parkride.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    
    @GetMapping
    public ResponseEntity<List<Employee>> listEmployee(){        
        return new ResponseEntity<>(employeeService.listAllEmployee(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployee(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee employeeObj = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeObj);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        Employee employeeDB = employeeService.getEmployee(id);
        if(employeeDB == null)
            return ResponseEntity.notFound().build();
        employee.setId(id);    
        employeeDB = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(employeeDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
                 
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
