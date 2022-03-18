package com.example.employeeControlSystem.service;

import java.util.List;

import com.example.employeeControlSystem.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	public Employee saveEmployee(Employee emp) ;
	
	public Employee editEmployee(long id,Employee emp);
	
	public Employee updateEmployee(long id,Employee emp);
	
	public void deleteEmployee(long id);
}
