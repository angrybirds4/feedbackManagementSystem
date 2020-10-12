package com.cg.fbms.service;

import java.util.ArrayList;

import com.cg.fbms.dto.CourseFacultyMapping;
import com.cg.fbms.dto.CourseMaster;
import com.cg.fbms.dto.Faculty;

public interface IFacutlyMaintenance {
	public boolean addFaculty(Faculty facultySkill);

	public ArrayList<Faculty> getAllFacultyList();

	public Faculty getFacultyById(int facultyId);

	public ArrayList<Integer> getAllFacultyId();

	public ArrayList<Faculty> getFacultyBySkill(String courseName);

	public boolean courseFacultyMapping(CourseFacultyMapping courseFacultyMapping);

	public ArrayList<Faculty> getMappedFacultyWithCourse(int courseId);

	public ArrayList<Faculty> getFacultyNotMappedWithCourse(CourseMaster courseMaster);

}
