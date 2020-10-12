package com.cg.fbms.dao;

import java.util.ArrayList;

import com.cg.fbms.dto.CourseMaster;

public interface ICourseMaintainenceDAO {
	public boolean addCourse(CourseMaster courseMaster);
	public boolean changeCourseName(int courseId ,String courseName);
	public boolean changeCourseDuration(int courseId, int courseDays );
	public CourseMaster getCourseById(int courseId);
	public ArrayList<CourseMaster> getAllCourse();

}
