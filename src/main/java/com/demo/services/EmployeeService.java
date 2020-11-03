package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Employee;
import com.demo.exceptions.EmployeeNotFoundException;
import com.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

	@Override
	public Employee findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	@Override
	public Employee save(Employee newEmployee) {

		return repository.save(newEmployee);
	}

	@Override
	public List<Employee> findAll() {

		return repository.findAll();
	}

	@Override
	public Employee replaceEmployee(Employee newEmployee, Long id) {
		return repository.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setRole(newEmployee.getRole());
			return repository.save(employee);
		}).orElseGet(() -> {
			newEmployee.setId(id);
			return repository.save(newEmployee);
		});
	}

}
