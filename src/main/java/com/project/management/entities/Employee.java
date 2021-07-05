package com.project.management.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	@SequenceGenerator(name="employee_seq",sequenceName="employee_seq", allocationSize = 1)
	private long employeeId;
	private String fname;
	private String lname;
	private String email;
	
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable(name="project_employee",
	joinColumns=@JoinColumn(name="employee_id"),
	inverseJoinColumns = @JoinColumn(name="project_id"))
	

	private List<Project> projects;
	public Employee() {
		
	}
	
	public Employee(String fname, String lname, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
