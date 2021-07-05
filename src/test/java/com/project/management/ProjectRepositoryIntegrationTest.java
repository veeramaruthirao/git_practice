package com.project.management;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project.management.dao.ProjectRepository;
import com.project.management.entities.Project;

// the below annotations used only if the test class pakage is different from main spring application package then we need to import all the contexts
// from main application so we need to import main class using context configuration annotation
/*@ContextConfiguration(classes=ManyTomanyApplication.class)
@DataJpaTest*/ 

@SpringBootTest
@ExtendWith(SpringExtension.class)

/*
 * this is not required for integration testing. we can insert one record from
 * this class and check the result we don't need the sql files in that case
 */  
  @SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD,scripts =
  {"classpath:schema.sql","classpath:data.sql"}),
  
  @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD,scripts =
  {"classpath:drop.sql"})})
 
public class ProjectRepositoryIntegrationTest {
	 
	@Autowired
	ProjectRepository prorepo;
	
	@Test
	public void ifNewProjectSaved_thenSucess() {
		Project pro=new Project("Spark Complete end to end application","Incomplete","development");
		prorepo.save(pro);
		
		  assertEquals(5 , prorepo.findAll().size()); 
		/* assertEquals(1 , prorepo.findAll().size()); */
		
	}
	
}
