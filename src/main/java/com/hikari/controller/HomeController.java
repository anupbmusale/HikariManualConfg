package com.hikari.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hikari.confg.model.Employee;
import com.hikari.confg.service.EmployeeService;  
@RestController  
public class HomeController {
	
	@GetMapping  
	public String hello()   
	{  
		return "Welcome to Spring boot PCF example...";  
	}
	
	@GetMapping("/employee/{id}")   
	public Employee getEmployee(@PathVariable String id)   
	{  
		EmployeeService emp = new EmployeeService();
		return emp.getEmployee(id);
	}  
}
