package com.gl.employeeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.employeeManagement.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
