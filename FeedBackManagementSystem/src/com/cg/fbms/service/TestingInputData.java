package com.cg.fbms.service;

import com.cg.fbms.dao.ILoginDAO;
import com.cg.fbms.dto.Employee;
import com.cg.fbms.dto.TrainingParticipantEnrollment;
import com.cg.fbms.dto.TrainingParticipantId;
import com.cg.fbms.dto.TrainingProgram;
import com.cg.fbms.utility.JPAUtility;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
public class TestingInputData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc  = new Scanner(System.in);
		
		//for authentication of employee
		
		/*Employee employee = null;
		employee = new Employee(sc.nextInt(),sc.next());
		LoginEmployeeService loginEmployee = new LoginEmployeeService();
		if(loginEmployee.loginAuthentication(employee)) {
			System.out.println("Login Successfully");
		}
		
		else System.out.println("Login Failed");*/
		
		/*IParticipantService getEnrollTrainingProgram = new ParticipantService();
		List<TrainingProgram> program = getEnrollTrainingProgram.enrollTrainingProgram(41841);
		for(TrainingProgram trainingProgram :program)
			System.out.println(trainingProgram);
		
		/*TrainingParticipantId id=new TrainingParticipantId(101,41482);
		TrainingParticipantEnrollment tPId= new TrainingParticipantEnrollment(id);
		System.out.println(tPId);
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		
		try {
			manager.persist(tPId);
			transaction.commit();
			
		} 
		catch (PersistenceException e) {
			transaction.rollback();
			System.out.println(e.getMessage());
			
		} 
		finally {
			manager.close();
			factory.close();
		}
		*/
		
		
		
	}

}
