package com.cg.fbms.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Training_Program")
public class TrainingProgram {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trainingId;
	private Date trainingStartDate;
	private Date trainingEndDate;
	
	private int courseId;
	private int facultyId;
	
	public TrainingProgram() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TrainingProgram( int courseId, int facultyId,Date trainingStartDate, Date trainingEndDate) {
		super();
		this.trainingStartDate = trainingStartDate;
		this.trainingEndDate = trainingEndDate;
		this.courseId = courseId;
		this.facultyId = facultyId;
	}
	
	

	public TrainingProgram(int trainingId, Date trainingStartDate, Date trainingEndDate, int courseId, int facultyId) {
		super();
		this.trainingId = trainingId;
		this.trainingStartDate = trainingStartDate;
		this.trainingEndDate = trainingEndDate;
		this.courseId = courseId;
		this.facultyId = facultyId;
	}



	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public Date getTrainingStartDate() {
		return trainingStartDate;
	}

	public void setTrainingStartDate(Date trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}

	public Date getTrainingEndDate() {
		return trainingEndDate;
	}

	public void setTrainingEndDate(Date trainingEndDate) {
		this.trainingEndDate = trainingEndDate;
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
		return "TrainingProgram [trainingId=" + trainingId + ", trainingStartDate=" + trainingStartDate
				+ ", trainingEndDate=" + trainingEndDate + ", courseId=" + courseId + ", facultyId=" + facultyId + "]";
	}
}
