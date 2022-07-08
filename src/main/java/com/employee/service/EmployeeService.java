package com.employee.parkride.service;

import java.util.List;

import com.employee.parkride.entity.Employee;

public interface EmployeeService {
    public List<Employee> listAllEmployee();
    public Employee getEmployee(Long id);
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(Long id);
}
