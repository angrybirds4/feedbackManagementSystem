package com.cg.fbms.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtility {
	
	private static final String PERSISTANCE_UNIT_NAME = "employee_fbms";
	private static EntityManagerFactory factory = null;


	public static  EntityManagerFactory getFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		}
		return factory;
	}

}
