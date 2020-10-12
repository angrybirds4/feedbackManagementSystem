package com.cg.fbms.service;

import java.util.ArrayList;

import com.cg.fbms.dto.CourseMaster;

public interface ICourseMaintenance {
	public boolean addCourse(CourseMaster cmaster);

	public boolean changeCourseName(int courseId, String courseName);

	public boolean changeCourseDuration(int courseId, int courseDays);

	public CourseMaster getCourseById(int courseId);

	public ArrayList<CourseMaster> getAllCourse();

}
