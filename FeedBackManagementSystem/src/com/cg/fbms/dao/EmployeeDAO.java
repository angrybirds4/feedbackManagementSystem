package com.cg.fbms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.cg.fbms.dto.Employee;
import com.cg.fbms.utility.JPAUtility;

public class EmployeeDAO implements IEmployeeDAO {

	@Override
	public boolean addEmployee(Employee employee) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		boolean flag = false;
		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();

		try {
			manager.persist(employee);
			transaction.commit();
			flag = true;
			return flag;
		} catch (PersistenceException persistExp) {
			transaction.rollback();
			System.err.println(persistExp.getMessage());
			return flag;
		} finally {
			manager.close();
			factory.close();
		}

	}

}
