package com.gl.employeeManagement.service;

import java.util.List;

import com.gl.employeeManagement.entity.Employee;



public interface EmployeeService {
	

	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int theId);
	
	public void saveEmployee(Employee theEmployee);
	
	public void updateEmployee(Employee theEmployee);
	
	public void deleteEmployeeById(int theId);

	
}
