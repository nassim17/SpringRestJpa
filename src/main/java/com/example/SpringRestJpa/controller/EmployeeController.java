package com.example.SpringRestJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringRestJpa.entity.Employee;
import com.example.SpringRestJpa.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/api/employees")
	public List<Employee> getEmployees(){
		List<Employee> employees = employeeService.retrieveEmployees();
		return employees;
	}
	
	@GetMapping("/api/employees/{employeeId}")
	public Employee getEmployee(@PathVariable (name = "employeeId") Long employeeId) {
		Employee employee = employeeService.getEmployee(employeeId);
		return employee;
	}
	
	@PostMapping("/api/employees")
	public void saveEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
	}
	
	@DeleteMapping("/api/empoyees/{empoyeeId}")
	public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		employeeService.deleteEmploye(employeeId);
	}
	
	@PutMapping("/api/empoyees/{empoyeeId}")
	public void updateEmployee(@RequestBody Employee employee,
								@PathVariable(name = "employeeId") Long employeeId) {
		Employee emp = employeeService.getEmployee(employeeId);
		if(emp != null){
			employeeService.updateEmployee(employee);
		}
	}
}
