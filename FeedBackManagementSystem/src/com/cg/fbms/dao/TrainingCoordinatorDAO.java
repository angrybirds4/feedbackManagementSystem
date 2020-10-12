package com.cg.fbms.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.fbms.dto.Employee;
import com.cg.fbms.dto.Faculty;
import com.cg.fbms.dto.TrainingProgram;
import com.cg.fbms.utility.JPAUtility;

public class TrainingCoordinatorDAO implements ITrainingCoordinatorDAO {

	EntityManagerFactory  factory = JPAUtility.getFactory();
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	
	public boolean addTrainingCourse(TrainingProgram TrainingP) {
		//transaction
		transaction.begin();
		try {
			manager.persist(TrainingP);
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			return false;
		}
		finally {
			manager.close();
			}
	}

}

