package com.project.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.management.dao.ProjectRepository;
import com.project.management.dto.ProjectStatus;
import com.project.management.entities.Project;



public class ProjectServices {
	@Autowired
	ProjectRepository prorepo;
	
	public Project save(Project project) {
		return prorepo.save(project);
	}
	
	public List<Project> getAll(){
		return prorepo.findAll();
	}
	
	public List<ProjectStatus> getProjectStatus(){
		return prorepo.getProjectStatus();
	}
}
