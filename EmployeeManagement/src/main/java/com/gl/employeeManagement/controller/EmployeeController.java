package com.gl.employeeManagement.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.employeeManagement.entity.Employee;
import com.gl.employeeManagement.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theemployeeService) {
		employeeService = theemployeeService;
	}



	@GetMapping("/employees")
	public String listEmployees(Model theModel) {

		// add to the spring model
		theModel.addAttribute("employees", employeeService.getAllEmployees());
		//System.out.println("***************"+employees+"************");

		return "employees";
	}

	@GetMapping("/employees/new")
	public String createEmployeeForm(Model theModel) {

		// create model attribute to bind form data
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "create_employee";
	}

	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
										
		employeeService.saveEmployee(employee);
		return "redirect:/employees";			
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable int id, Model theModel) {

	
		theModel.addAttribute("employee", employeeService.getEmployeeById(id));

		return "edit_employee";
	}
	
	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable int id,@ModelAttribute("employee") Employee employee,Model model) {

	
		Employee existingEmployee =employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		
		employeeService.updateEmployee(existingEmployee);

		return "redirect:/employees";
	}

	

	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {

		// delete the employee
		employeeService.deleteEmployeeById(id);

	
		return "redirect:/employees";

	}

}
