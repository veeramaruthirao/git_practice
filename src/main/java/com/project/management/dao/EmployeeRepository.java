package com.project.management.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.management.dto.EmployeeProject;
import com.project.management.entities.Employee;


@Repository
@Profile("prod")
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Override
	public List<Employee> findAll();
	
	/*
	 * @Query(nativeQuery=true,
	 * value="select e.fname as Firstname, e.lname as Lastname,COUNT(pe.employee_id) "
	 * + "as Project_count  from employee e left join project_employee pe ON " +
	 * " e.employee_id=pe.employee_id group by e.fname, e.lname ORDER BY 3 desc")
	 */
	@Query(nativeQuery=true, value="select e.fname as Firstname, e.lname as Lastname,COUNT(pe.employee_id) "
			+ "as Project_count  from employee e left join project_employee pe ON "
			+ " e.employee_id=pe.employee_id group by e.fname, e.lname ORDER BY 3 desc")
	public List<EmployeeProject> employeeprojects();
}
