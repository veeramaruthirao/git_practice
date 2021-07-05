package com.project.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.management.dao.EmployeeRepository;
import com.project.management.dao.ProjectRepository;
import com.project.management.entities.Employee;
import com.project.management.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository prorepo;
	
	@Autowired
	EmployeeRepository emprepo;
	@GetMapping
	public String displayprojects(Model model) {
		List<Project> projects = prorepo.findAll();
		model.addAttribute("projects",projects);
		return "/list-projects";
	}
	@RequestMapping(value = "/new")
	public String displayProjectform(Model model) {
		List<Employee> employees= emprepo.findAll();
		model.addAttribute("project", new Project());
		model.addAttribute("allEmployees", employees);
		return "/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project,@RequestParam List<Long> employees,Model model) {
		prorepo.save(project);
		

		return "redirect:/projects/new";
	}
}
