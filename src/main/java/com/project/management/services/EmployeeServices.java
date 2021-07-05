package com.project.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.management.dao.EmployeeRepository;
import com.project.management.dto.EmployeeProject;
import com.project.management.entities.Employee;

@Service
public class EmployeeServices {

	@Autowired
	EmployeeRepository emprepo;
	
	public Employee save(Employee employee) {
		return emprepo.save(employee);
	}
	
	public List<Employee> getAll(){
		return emprepo.findAll();
	}
	
	public List<EmployeeProject> employeeProjects(){
		return emprepo.employeeprojects();
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
