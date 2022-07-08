package com.employee.parkride.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee.parkride.entity.Employee;
import com.employee.parkride.entity.exception.ResourceNotFoundException;
import com.employee.parkride.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    @Override
    public List<Employee> listAllEmployee() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElseThrow(()-> new ResourceNotFoundException(id.toString()));
    }
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public Employee updateEmployee(Employee employee) {
        Employee foundEmployee = getEmployee(employee.getId());
        if(foundEmployee == null)
            return null;
        foundEmployee.setFirstName(employee.getFirstName());
        foundEmployee.setLastName(employee.getLastName());
        foundEmployee.setEmail(employee.getEmail());
        return employeeRepository.save(foundEmployee);
    }
    @Override
    public void deleteEmployee(Long id) {
        Employee foundEmployee = getEmployee(id);
        if(foundEmployee == null)
            System.out.println("Not Found");
        employeeRepository.deleteById(id);
    }
}
