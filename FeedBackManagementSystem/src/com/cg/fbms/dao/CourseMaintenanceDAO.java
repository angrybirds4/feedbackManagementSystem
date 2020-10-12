package com.cg.fbms.dao;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.cg.fbms.dto.CourseMaster;
import com.cg.fbms.utility.JPAUtility;

public class CourseMaintenanceDAO implements ICourseMaintenanceDAO,QueryConstants {
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	
	@Override
	public boolean addCourse(CourseMaster courseMaster) {
		// TODO Auto-generated method stub
		
		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		boolean status=false;
		
		try {
			transaction.begin();
			manager.persist(courseMaster);
			transaction.commit();
			status = true;
		} 
		catch (PersistenceException c) {
			transaction.rollback();
			System.err.println(c.getMessage());
			status = false;
		}
		finally {
			manager.close();
		}
		return status;
	}

	@Override
	public boolean changeCourseName(int courseId, String courseName) {
		// TODO Auto-generated method stub
		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		boolean status=false;
		
		try {
			CourseMaster courseMaster = manager.find(CourseMaster.class, courseId);
			courseMaster.setCourseName(courseName);
			status= true;;
		}
		catch (PersistenceException c) {
			System.err.println(c.getMessage());
		} 
		finally {
			manager.close();
		}
		
		return status;

	}

	@Override
	public boolean changeCourseDuration(int courseId, int courseDays) {
		// TODO Auto-generated method stub
		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		boolean status=false;

		try {
			CourseMaster courseMaster = manager.find(CourseMaster.class, courseId);
			courseMaster.setCourseDays(courseDays);
			status =  true;
		} 
		catch (PersistenceException c) {
			System.err.println(c.getMessage());
		}
		finally {
			manager.close();
		}
		
		return status;
	}

	@Override
	public CourseMaster getCourseById(int courseId) {
		// TODO Auto-generated method stub
		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		
		
		CourseMaster courseMaster = null;
		
		try {
			courseMaster = manager.find(CourseMaster.class, courseId);
			
		} 
		catch (PersistenceException c) {
			System.err.println(c.getMessage());
		}
		finally {
			manager.close();
		}

		return courseMaster;
	}

	
	@Override
	public ArrayList <CourseMaster> getAllCourse() {
		// TODO Auto-generated method stub
		ArrayList<CourseMaster> allCourseList = new ArrayList<CourseMaster>();
		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		
		try {
			allCourseList =	(ArrayList<CourseMaster>)manager.createQuery(GET_ALL_COURSE_LIST,CourseMaster.class).getResultList();
		}
		catch (PersistenceException p) {
			// TODO: handle exception
			System.err.println(p.getMessage());
		}
		finally {
			manager.close();
		}
		
		return allCourseList;
	}

}
