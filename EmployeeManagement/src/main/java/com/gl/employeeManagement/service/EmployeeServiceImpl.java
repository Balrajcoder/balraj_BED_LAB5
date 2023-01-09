package com.gl.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employeeManagement.dao.EmployeeRepo;
import com.gl.employeeManagement.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo employeeRepository;


	public EmployeeServiceImpl(EmployeeRepo theemployeeRepository) {
		employeeRepository = theemployeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> theEmployees = employeeRepository.findAll();
		return theEmployees;
	}

	@Override
	public Employee getEmployeeById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the book
			throw new RuntimeException("Did not find book id - " + theId);
		}

		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteEmployeeById(int theId) {
		employeeRepository.deleteById(theId);

	}

	@Override
	public void updateEmployee(Employee theEmployee) {

		employeeRepository.save(theEmployee);

	}

}
