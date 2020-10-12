package com.cg.fbms.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.cg.fbms.dto.CourseFacultyMapping;
import com.cg.fbms.dto.CourseMaster;
import com.cg.fbms.dto.Faculty;
import com.cg.fbms.utility.JPAUtility;

public class FacultyMaintenanceDAOImpl implements IFacultyMaintenanceDAO,QueryConstants{

	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	
	private  ArrayList<Faculty> facultyList = null;
	
	
	@Override
	public boolean addFacultySkillSet(Faculty facultySkill) {
		// TODO Auto-generated method stub
		factory = JPAUtility.getFactory();
		manager  = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(facultySkill);
			transaction.commit();
			return true;
		}
		catch (PersistenceException p) {
			// TODO: handle exception
			transaction.rollback();
			System.out.println(p);
			return false;
		}
		
		finally {
			manager.close();
		}
		
		
	}

	@Override
	public ArrayList<Faculty> displayAllFacultyList() {
		// TODO Auto-generated method stub
		factory = JPAUtility.getFactory();
		manager  = factory.createEntityManager();
		
		ArrayList<Faculty> facultyList =null;
		try {
			facultyList = (ArrayList<Faculty>) manager.createQuery(GET_ALL_FACULTY_LIST,Faculty.class).getResultList();			
		}
		catch (PersistenceException p) {
			System.out.println(p);			 
		}
		finally {
			manager.close();
		}
		 return facultyList;
	}

	@Override
	public Faculty displayFacultyById(int facultyId) {
		// TODO Auto-generated method stub
		factory = JPAUtility.getFactory();
		manager  = factory.createEntityManager();
		Faculty faculty = null;
		try {
			 faculty = manager.find(Faculty.class, facultyId);
		}
		catch (PersistenceException p) {
			// TODO: handle exception
			
		}
		return faculty;
	}

	@Override
	public ArrayList<Integer> getAllFacultyId() {
		// TODO Auto-generated method stub
		ArrayList<Integer> allFaculytId = new ArrayList<Integer>();
		facultyList = new FacultyMaintenanceDAOImpl().displayAllFacultyList();	
			
			
		for(Faculty faculty: facultyList) {
			allFaculytId.add(faculty.getFacultyId());
		}
		return allFaculytId;
	}

	@Override
	public ArrayList<Faculty> getFacultyBySkill(String courseName) {
		// TODO Auto-generated method stub
		
		facultyList = new FacultyMaintenanceDAOImpl().displayAllFacultyList();
		ArrayList<Faculty> facultyHavingParticularSkill = new ArrayList<Faculty>();
		for(Faculty facultySkill : facultyList) {
			List<String> skillSet = Arrays.asList(facultySkill.getFacultySkillSet().split(","));
			if(skillSet.contains(courseName)) {
				facultyHavingParticularSkill.add(facultySkill);
			}
		}
		
		return facultyHavingParticularSkill;
	}

	
	//for mapping part of course and faculty
	
	@Override
	public boolean courseFacultyMapping(CourseFacultyMapping courseFacultyMapping) {
		// TODO Auto-generated method stub
		factory = JPAUtility.getFactory();
		manager  = factory.createEntityManager();
		transaction = manager.getTransaction();
		boolean status=false;
		
		try {
			transaction.begin();
			manager.persist(courseFacultyMapping);
			transaction.commit();
			status = true;
		}
		catch (PersistenceException p) {
			// TODO: handle exception
			System.err.println(p);
		}
		
		finally {
			manager.close();
		}
		
		return status;
		
	}

	
	
	@Override
	public ArrayList<Faculty> getMappedFacultyWithCourse(int courseId) {
		// TODO Auto-generated method stub

		factory = JPAUtility.getFactory();
		manager  = factory.createEntityManager();
		ArrayList<Faculty> allFacultyId =null;
		
		try {
			 
			Query query  = manager.createQuery(GET_ALL_FACULTY_ID_BY_COURSENAME);
			query.setParameter(1, courseId);
			allFacultyId = (ArrayList<Faculty>) query.getResultList();
		}
		catch (PersistenceException p) {
			System.err.println(p);			 
		}
		finally {
			manager.close();
		}
		 
		
		return allFacultyId;
	}

	@Override
	public ArrayList<Faculty> getFacultyNotMappedWithCourse(CourseMaster courseMaster) {
		// TODO Auto-generated method stub
		
		
		factory = JPAUtility.getFactory();
		manager  = factory.createEntityManager();
		
		
		ArrayList<Faculty> facultyNotMappedWithCourse = new ArrayList<Faculty>();
		
		IFacultyMaintenanceDAO facultyMaintenanceDAO = new FacultyMaintenanceDAOImpl();
		ArrayList<Faculty> facultyDetailsBySkill = facultyMaintenanceDAO.getFacultyBySkill(courseMaster.getCourseName());
		
		
		ArrayList<Integer> mappedFacultyId =null;
		try {
			 
			Query query  = manager.createQuery(GET_ALL_FACULTY_ID_BY_COURSENAME);
			query.setParameter(1, courseMaster.getCourseId());
			mappedFacultyId = (ArrayList<Integer>) query.getResultList();
		}
		catch (PersistenceException p) {
			System.out.println(p);			 
		}
		finally {
			manager.close();
		}
		
		for(Faculty allFaultyWithCourse : facultyDetailsBySkill) {
			if(!mappedFacultyId.contains(allFaultyWithCourse.getFacultyId())) {
				facultyNotMappedWithCourse.add(allFaultyWithCourse);
			}
		}
		return facultyNotMappedWithCourse;
	}
	
}
