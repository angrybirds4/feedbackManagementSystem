package com.cg.fbms.service;

import java.util.ArrayList;

import com.cg.fbms.dao.CourseMaintenanceDAO;
import com.cg.fbms.dao.ICourseMaintenanceDAO;
import com.cg.fbms.dto.CourseMaster;

public class CourseMaintenanceService implements ICourseMaintenance{
	
	ICourseMaintenanceDAO courseMaintainDao = new CourseMaintenanceDAO();
	
	
	@Override
	public boolean addCourse(CourseMaster courseMaster) {
		if(courseMaster.getCourseName()!=null && courseMaster.getCourseDays()!=0 && courseMaster.getCourseName()!="") {
			boolean newCourseStatus = courseMaintainDao.addCourse(courseMaster);
			return newCourseStatus;			
		}
		return false;
	}

	@Override
	public boolean changeCourseName(int courseId, String courseName) {
		// TODO Auto-generated method stub
		
		boolean CourseNameStatus = courseMaintainDao.changeCourseName(courseId, courseName);
		return CourseNameStatus;
		
		
		
	}

	@Override
	public boolean changeCourseDuration(int courseId, int courseDays) {
		// TODO Auto-generated method stub
		boolean CourseDuratioStatus = courseMaintainDao.changeCourseDuration(courseId, courseDays);
		return CourseDuratioStatus;
	}

	@Override
	public CourseMaster getCourseById(int courseId) {
		// TODO Auto-generated method stub
		return courseMaintainDao.getCourseById(courseId);
	}

	@Override
	public ArrayList<CourseMaster> getAllCourse() {
		// TODO Auto-generated method stub
		return courseMaintainDao.getAllCourse();
	}
	
}
