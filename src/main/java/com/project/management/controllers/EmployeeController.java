package com.project.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.management.dao.EmployeeRepository;
import com.project.management.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	
	  @Autowired 
	  EmployeeRepository emprepo;
	 
	
	/*
	 * @Autowired EmployeeServices emprepo;
	 */
	
	@GetMapping
	public String displayemployees(Model model) {
		List<Employee> employees = emprepo.findAll();
		model.addAttribute("employee",employees);
		return "/list-employees";
	}

	@RequestMapping(value = "/newemp")
	public String displayProjectform(Model model) {
		model.addAttribute("employee", new Employee());
		return "new-employee";
	}
	
	@PostMapping("/save")
	public String createProject(Employee employee,Model model) {
		emprepo.save(employee);
		
	    
	    	
		return "redirect:/employees/newemp";
	}
}
