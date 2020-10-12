package com.cg.fbms.service;

import java.util.ArrayList;

import com.cg.fbms.dao.FacultyMaintenanceDAOImpl;
import com.cg.fbms.dao.IFacultyMaintenanceDAO;
import com.cg.fbms.dto.CourseFacultyMapping;
import com.cg.fbms.dto.CourseMaster;
import com.cg.fbms.dto.Faculty;

public class FacultymaintenanceService implements IFacutlyMaintenance {

	private IFacultyMaintenanceDAO facultyMaintenanceDao = new FacultyMaintenanceDAOImpl();
	
	
	@Override
	public boolean addFaculty(Faculty faculty) {
		if(faculty.getFacultyName()!=null && faculty.getFacultySkillSet()!=null && !faculty.getFacultyName().equals("") && !faculty.getFacultySkillSet().equals("")) {
			return facultyMaintenanceDao.addFacultySkillSet(faculty);
		}
		return false;
		
	}


	@Override
	public ArrayList<Faculty> getAllFacultyList() {
		// TODO Auto-generated method stub
		return facultyMaintenanceDao.displayAllFacultyList();
		
	}


	@Override
	public Faculty getFacultyById(int facultyId) {
		// TODO Auto-generated method stub
		return facultyMaintenanceDao.displayFacultyById(facultyId);
	}


	@Override
	public ArrayList<Integer> getAllFacultyId() {
		// TODO Auto-generated method stub
		return facultyMaintenanceDao.getAllFacultyId();
	}


	@Override
	public ArrayList<Faculty> getFacultyBySkill(String courseName) {
		// TODO Auto-generated method stub
		return facultyMaintenanceDao.getFacultyBySkill(courseName);
	}


	@Override
	public boolean courseFacultyMapping(CourseFacultyMapping courseFacultyMapping) {
		// TODO Auto-generated method stub
		return facultyMaintenanceDao.courseFacultyMapping(courseFacultyMapping);
	}


	@Override
	public ArrayList<Faculty> getMappedFacultyWithCourse(int courseId) {
		// TODO Auto-generated method stub
		return facultyMaintenanceDao.getMappedFacultyWithCourse(courseId);
	}


	@Override
	public ArrayList<Faculty> getFacultyNotMappedWithCourse(CourseMaster courseMaster) {
		// TODO Auto-generated method stub
		return facultyMaintenanceDao.getFacultyNotMappedWithCourse(courseMaster);
	}

}
