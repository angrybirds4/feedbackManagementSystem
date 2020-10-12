package com.cg.fbms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table  (name="Course_Master")
public class CourseMaster {
	@Id
	@GeneratedValue
	private int courseId;
	private String courseName;
	private int courseDays;
	
	
	public CourseMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public CourseMaster(int courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}


	

	public CourseMaster(String courseName, int courseDays) {
		super();
		this.courseName = courseName;
		this.courseDays = courseDays;
	}




	public CourseMaster(int courseId, String courseName, int courseDays) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDays = courseDays;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public int getCourseDays() {
		return courseDays;
	}


	public void setCourseDays(int courseDays) {
		this.courseDays = courseDays;
	}


	@Override
	public String toString() {
		return "CourseMaster [courseId=" + courseId + ", courseName=" + courseName + ", courseDays=" + courseDays + "]";
	}


	
	
	
	
	

}
