package com.parkridejenkins.parkride.service;

import java.util.List;
import java.util.Optional;

import com.parkridejenkins.parkride.entity.Employee;
import com.parkridejenkins.parkride.entity.exception.ResourceNotFoundException;
import com.parkridejenkins.parkride.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

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
