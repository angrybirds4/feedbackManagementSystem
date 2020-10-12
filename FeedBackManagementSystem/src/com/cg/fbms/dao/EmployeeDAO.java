package com.cg.fbms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.cg.fbms.dto.Employee;
import com.cg.fbms.utility.JPAUtility;

public class EmployeeDAO implements IEmployeeDAO{
	
	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		

			EntityManagerFactory factory = null;
			EntityManager manager = null;
			EntityTransaction transaction = null;

			factory = JPAUtility.getFactory();
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			
			try {
				manager.persist(employee);
				transaction.commit();
				return true;
			} 
			catch (PersistenceException e) {
				transaction.rollback();
				System.out.println(e.getMessage());
				return false;
			} 
			finally {
				manager.close();
				factory.close();
			}
			
	
		}
		
	}
	
