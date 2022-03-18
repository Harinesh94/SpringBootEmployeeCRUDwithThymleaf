package com.example.employeeControlSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.employeeControlSystem.model.Employee;
import com.example.employeeControlSystem.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public String getAllEmployees(Model mav) {
		List<Employee> empList = employeeService.getAllEmployees();
		mav.addAttribute("employeeList", empList);
		return "view_employees";		
	}
	
	@GetMapping("/viewCreate")
	public String viewCreateEmployeePage() {
		return "create_employee";	
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployeeDetails(@ModelAttribute("employee") Employee emp) {
		employeeService.saveEmployee(emp);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String updateEmployee(@PathVariable long id,@ModelAttribute("employee") Employee emp,Model model) {
		Employee employee =  employeeService.editEmployee(id,emp);
		model.addAttribute("employee", employee);
		return "update_employee";
		
	}
	
	@PostMapping("/updateEmployee/{id}")
	public String updateEmployeeDetails(@PathVariable long id,@ModelAttribute("employee") Employee employee) {
		employeeService.updateEmployee(id, employee);
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
}
