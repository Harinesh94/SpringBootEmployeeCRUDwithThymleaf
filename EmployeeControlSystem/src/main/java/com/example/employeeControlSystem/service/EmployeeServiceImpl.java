package com.example.employeeControlSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeeControlSystem.model.Employee;
import com.example.employeeControlSystem.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository emRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return emRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return emRepository.save(emp);
	}

	@Override
	public Employee editEmployee(long id,Employee employee) {
		Optional<Employee> emp = emRepository.findById(id);
		
		if(emp.isPresent()) {
			Employee empObj = emp.get();
//			empObj.setName(employee.getName());
//			empObj.setDepartment(employee.getDepartment());
//			empObj.setAddress(employee.getAddress());
//			empObj.setCountry(employee.getCountry());
//			empObj.setExperience(employee.getExperience());
//			empObj.setGender(employee.getGender());
//			//empObj.setPanAvailable(employee.get);
//			empObj.setSalary(employee.getSalary());
//			return emRepository.save(empObj);
			return empObj;
		}else {
			return null;
		}
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
Optional<Employee> emp = emRepository.findById(id);
		
		if(emp.isPresent()) {
			Employee empObj = emp.get();
			empObj.setName(employee.getName());
			empObj.setDepartment(employee.getDepartment());
			empObj.setAddress(employee.getAddress());
			empObj.setCountry(employee.getCountry());
			empObj.setExperience(employee.getExperience());
			empObj.setGender(employee.getGender());
			//empObj.setPanAvailable(employee.get);
			empObj.setSalary(employee.getSalary());
			return emRepository.save(empObj);
		}else {
			return null;
		}
	}
	

	@Override
	public void deleteEmployee(long id) {
		Optional<Employee> emp = emRepository.findById(id);
		if(emp.isPresent()) {
			emRepository.deleteById(id);
		}
	}

}
