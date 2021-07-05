package com.project.management.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.management.dao.EmployeeRepository;
import com.project.management.dao.ProjectRepository;
import com.project.management.dto.EmployeeProject;
import com.project.management.dto.ProjectStatus;
import com.project.management.entities.Employee;
import com.project.management.entities.Project;
import com.project.management.sprinExample.Car;

@Controller
@RequestMapping("/")
public class HomeController {

	@Value("${version}")
	private String ver;
	
	@Autowired
	ProjectRepository prorepo;
	@Autowired
	EmployeeRepository emprepo;
	
	@Autowired
	Car car;
	
	@RequestMapping("/home")
	public String displayHome(Model model) throws JsonProcessingException {

		Map<String, Object> map = new HashMap<>();
		
		List<Project> aproject=prorepo.findAll();
		List<Employee> anEmployee=emprepo.findAll();
		List<EmployeeProject> proCount=emprepo.employeeprojects();
		
		List<ProjectStatus> chartData=prorepo.getProjectStatus(); // convert this java type into more generic like JSON
		// lets convert Project data object into a json struture for use in java script
		ObjectMapper objectmapper= new ObjectMapper();
		String jsonstrng= objectmapper.writeValueAsString(chartData);
		
		model.addAttribute("homeproject", aproject); 
		model.addAttribute("employ", anEmployee);
		model.addAttribute("procount", proCount);
		
		model.addAttribute("VersionNumber", ver);
		
		 
		
		return "home";
	}
	

	
	@RequestMapping("/employee")
	public String displayemp(Model model) {
		List<Employee> anEmployee=emprepo.findAll();
		model.addAttribute("employ", anEmployee);
		return "employee";
	}
	
	
	
}
