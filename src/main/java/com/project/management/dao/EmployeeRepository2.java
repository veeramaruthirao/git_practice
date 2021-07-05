package com.project.management.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.project.management.dto.EmployeeProject;
import com.project.management.entities.Employee;

@Repository
@Profile("dev")
public class EmployeeRepository2 implements EmployeeRepository {

	@Override
	public <S extends Employee> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Employee> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Employee> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		Employee emp1= new Employee("maruthi","pydikondala","maruthi@gmail.com");
		Employee emp2= new Employee("leela","patamasetti","leela780@gmail.com");
		Employee emp3= new Employee("Harish","vallabhaneni","vallabhanenih@gmail.com");
		
		return Arrays.asList(emp1,emp2,emp3);
		
	}

	@Override
	public List<EmployeeProject> employeeprojects() {
		// TODO Auto-generated method stub
		EmployeeProject empProj = new EmployeeProject() {
			
			@Override
			public String getFirstname() {
				return "maruthi";
			}
			
			@Override
			public String getLastname() {
				return "pydikondala";
			}

			@Override
			public int getProject_count() {
				// TODO Auto-generated method stub
				return 10;
			}
		
	
		};
		return Arrays.asList(empProj);

	}
}
