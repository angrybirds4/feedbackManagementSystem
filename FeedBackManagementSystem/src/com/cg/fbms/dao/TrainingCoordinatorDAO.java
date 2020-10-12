package com.cg.fbms.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.cg.fbms.dto.Employee;
import com.cg.fbms.dto.Faculty;
import com.cg.fbms.dto.TrainingProgram;
import com.cg.fbms.utility.JPAUtility;

public class TrainingCoordinatorDAO implements ITrainingCoordinatorDAO {

	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;

	public boolean addTrainingCourse(TrainingProgram TrainingP) {
		// transaction

		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		boolean flag = false;
		try {
			manager.persist(TrainingP);
			transaction.commit();
			flag = true;
			return flag;
		} catch (PersistenceException persistExp) {
			transaction.rollback();
			System.err.println(persistExp.getMessage());
			return flag;
		} finally {
			manager.close();
		}
	}

}
