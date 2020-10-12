package com.cg.fbms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Course_Faculty_Mapping")
public class CourseFacultyMapping {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mappingId;
	private int courseId;
	private int facultyId;
	
	
	
	public CourseFacultyMapping() {
		super();
	}



	public CourseFacultyMapping(int courseId, int facultyId) {
		super();
		this.courseId = courseId;
		this.facultyId = facultyId;
	}



	public CourseFacultyMapping(int mappingId, int courseId, int facultyId) {
		super();
		this.mappingId = mappingId;
		this.courseId = courseId;
		this.facultyId = facultyId;
	}



	public int getMappingId() {
		return mappingId;
	}



	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
	}



	public int getCourseId() {
		return courseId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}



	public int getFacultyId() {
		return facultyId;
	}



	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}



	@Override
	public String toString() {
		return "CourseFacultyMapping [mappingId=" + mappingId + ", courseId=" + courseId + ", facultyId=" + facultyId
				+ "]";
	}
	
	
	
	
}
