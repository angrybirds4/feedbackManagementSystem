package com.cg.fbms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.cg.fbms.dto.Employee;
import com.cg.fbms.utility.JPAUtility;

public class LoginDAOImpl implements ILoginDAO {

	private String employeeRole = null;
	private String employeeName = null;

	@Override
	public boolean validateEmployee(Employee employee) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();

		try {
			Employee employeeInfo = manager.find(Employee.class, employee.getEmployeeId());
			// System.out.println("password " + employeeInfo.getEmployeePassword() + "
			// "+employeeInfo.getEmployeeName() );
			if (employeeInfo.getEmployeePassword().equals(employee.getEmployeePassword())) {
				employeeRole = employeeInfo.getEmployeeRole();
				employeeName = employeeInfo.getEmployeeName();
				return true;
			}

			else
				return false;
		} catch (PersistenceException persistExp) {
			System.err.println(persistExp.getMessage());
			return false;
		}
	}

	@Override
	public String getEmployeeRole() {

		return employeeRole;
	}

	@Override
	public String getEmployeeName() {

		return employeeName;
	}

}
