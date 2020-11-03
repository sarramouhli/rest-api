package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.services.IEmployeeService;

import io.swagger.annotations.ApiOperation;

import com.demo.entities.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@ApiOperation(value = "Show All Employees", notes = "This will provide the the Employee information", response = Employee.class)
	@GetMapping("/employees")
	public List<Employee> all() {
		return employeeService.findAll();
	}

	@PostMapping("/employees")
	public Employee newEmployee(@RequestBody Employee newEmployee) {
		return employeeService.save(newEmployee);
	}

	@GetMapping("/employees/{id}")
	public Employee one(@PathVariable Long id) {

		return employeeService.findById(id);
	}

	@PutMapping("/employees/{id}")
	public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		return employeeService.replaceEmployee(newEmployee, id);

	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteById(id);
	}
}
