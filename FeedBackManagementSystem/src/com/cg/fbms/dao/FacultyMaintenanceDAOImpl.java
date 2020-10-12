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

public class FacultyMaintenanceDAOImpl implements IFacultyMaintenanceDAO, QueryConstants {

	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;

	private ArrayList<Faculty> facultyList = null;

	@Override
	public boolean addFacultySkillSet(Faculty facultySkill) {

		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		boolean flag = false;
		try {
			transaction.begin();
			manager.persist(facultySkill);
			transaction.commit();
			flag = true;
			return flag;
		} catch (PersistenceException persistExp) {
			// TODO: handle exception
			transaction.rollback();
			System.err.println(persistExp.getMessage());
			return flag;
		}

		finally {
			manager.close();
		}

	}

	@Override
	public ArrayList<Faculty> displayAllFacultyList() {

		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();

		ArrayList<Faculty> facultyList = null;
		try {
			facultyList = (ArrayList<Faculty>) manager.createQuery(GET_ALL_FACULTY_LIST, Faculty.class).getResultList();
		} catch (PersistenceException persistExp) {

			System.err.println(persistExp.getMessage());
		} finally {
			manager.close();
		}
		return facultyList;
	}

	@Override
	public Faculty displayFacultyById(int facultyId) {

		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		Faculty faculty = null;
		try {
			faculty = manager.find(Faculty.class, facultyId);
		} catch (PersistenceException persistExp) {
			System.err.println(persistExp.getMessage());

		}
		return faculty;
	}

	@Override
	public ArrayList<Integer> getAllFacultyId() {

		ArrayList<Integer> allFaculytId = new ArrayList<Integer>();
		facultyList = new FacultyMaintenanceDAOImpl().displayAllFacultyList();

		for (Faculty faculty : facultyList) {
			allFaculytId.add(faculty.getFacultyId());
		}
		return allFaculytId;
	}

	@Override
	public ArrayList<Faculty> getFacultyBySkill(String courseName) {

		facultyList = new FacultyMaintenanceDAOImpl().displayAllFacultyList();
		ArrayList<Faculty> facultyHavingParticularSkill = new ArrayList<Faculty>();
		for (Faculty facultySkill : facultyList) {
			List<String> skillSet = Arrays.asList(facultySkill.getFacultySkillSet().split(","));
			if (skillSet.contains(courseName)) {
				facultyHavingParticularSkill.add(facultySkill);
			}
		}

		return facultyHavingParticularSkill;
	}

	// for mapping part of course and faculty

	@Override
	public boolean courseFacultyMapping(CourseFacultyMapping courseFacultyMapping) {

		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		boolean status = false;

		try {
			transaction.begin();
			manager.persist(courseFacultyMapping);
			transaction.commit();
			status = true;
		} catch (PersistenceException persistExp) {

			System.err.println(persistExp.getMessage());
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
		manager = factory.createEntityManager();
		ArrayList<Faculty> allFacultyId = null;

		try {

			Query query = manager.createQuery(GET_ALL_FACULTY_ID_BY_COURSENAME);
			query.setParameter(1, courseId);
			allFacultyId = (ArrayList<Faculty>) query.getResultList();
		} catch (PersistenceException p) {
			System.err.println(p);
		} finally {
			manager.close();
		}

		return allFacultyId;
	}

	@Override
	public ArrayList<Faculty> getFacultyNotMappedWithCourse(CourseMaster courseMaster) {

		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();

		ArrayList<Faculty> facultyNotMappedWithCourse = new ArrayList<Faculty>();

		IFacultyMaintenanceDAO facultyMaintenanceDAO = new FacultyMaintenanceDAOImpl();
		ArrayList<Faculty> facultyDetailsBySkill = facultyMaintenanceDAO
				.getFacultyBySkill(courseMaster.getCourseName());

		ArrayList<Integer> mappedFacultyId = null;
		try {

			Query query = manager.createQuery(GET_ALL_FACULTY_ID_BY_COURSENAME);
			query.setParameter(1, courseMaster.getCourseId());
			mappedFacultyId = (ArrayList<Integer>) query.getResultList();
		} catch (PersistenceException p) {
			System.out.println(p);
		} finally {
			manager.close();
		}

		for (Faculty allFaultyWithCourse : facultyDetailsBySkill) {
			if (!mappedFacultyId.contains(allFaultyWithCourse.getFacultyId())) {
				facultyNotMappedWithCourse.add(allFaultyWithCourse);
			}
		}
		return facultyNotMappedWithCourse;
	}

}
