package com.project.management.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
/*	..* represents the class and methods*/
/*
 * @Pointcut("within(com.project.management.controllers..*)") public void
 * definePackagePointcuts() { // empty method just to name the location
 * specified in the pointcut
 * 
 * }
 */
	
	@Pointcut("within(com.project.management.controllers..*)" + "|| within(com.project.management.dao..*)")
	public void definePackagePointcuts() {
		// empty method just to name the location specified in the pointcut
		
	}
	
	/*
	 * @After("definePackagePointcuts()") public void log() {
	 * log.debug("--------------AFTER---------------------"); }
	 */
	
	@After("definePackagePointcuts()")
	public void log(JoinPoint jp) {
		log.debug("\n \n \n");
		log.debug("--------------BEFORE--------------- \n {}.{} with argumetns[s] = {}",
		jp.getSignature().getDeclaringTypeName(),
		jp.getSignature().getName(),Arrays.toString(jp.getArgs())		
				);
		log.debug("___________________________________________________");
	}
	
	
	@Around("definePackagePointcuts()")
	public Object logaround(ProceedingJoinPoint jp) {
		log.debug("\n \n \n");
		log.debug("--------------BEFORE--------------- \n {}.{} with argumetns[s] = {}",
		jp.getSignature().getDeclaringTypeName(),
		jp.getSignature().getName(),Arrays.toString(jp.getArgs()));
		log.debug("___________________________________________________");
		
		Object o= null;
		try {
			o = jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.debug("\n \n \n");
		log.debug("--------------AFTER--------------- \n {}.{} with argumetns[s] = {}",
		jp.getSignature().getDeclaringTypeName(),
		jp.getSignature().getName(),Arrays.toString(jp.getArgs()));
		log.debug("___________________________________________________");
		
		return o;
	}
}
