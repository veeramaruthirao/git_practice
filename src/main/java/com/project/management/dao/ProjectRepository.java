package com.project.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.management.dto.ProjectStatus;
import com.project.management.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{

	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true, value= "SELECT stage as label,count(*) as value from project group by stage" )
	public List<ProjectStatus> getProjectStatus();
	
	}
