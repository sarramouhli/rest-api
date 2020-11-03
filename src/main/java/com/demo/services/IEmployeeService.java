package com.demo.services;

import java.util.List;

import com.demo.entities.Employee;

public interface IEmployeeService {

	void deleteById(Long id);

	Employee findById(Long id);

	Employee save(Employee newEmployee);

	List<Employee> findAll();

	Employee replaceEmployee(Employee newEmployee, Long id);

}
