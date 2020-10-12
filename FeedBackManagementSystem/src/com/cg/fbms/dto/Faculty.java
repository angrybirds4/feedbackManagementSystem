package com.cg.fbms.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;


@Entity
@Table(name="FacultySkill")
public class Faculty {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int facultyId;
	
	private String facultyName;
	private String facultySkillSet;
	
	
	
	
	public Faculty() {
		super();
	}

	public Faculty(String facultyName, String facultySkillSet) {
		super();
		this.facultySkillSet = facultySkillSet;
		this.facultyName = facultyName;
	}

	public Faculty(int facultyId, String facultyName, String facultySkillSet) {
		super();
		this.facultyId = facultyId;
		this.facultySkillSet = facultySkillSet;
		this.facultyName = facultyName;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultySkillSet() {
		return facultySkillSet;
	}

	public void setFacultySkillSet(String facultySkillSet) {
		this.facultySkillSet = facultySkillSet;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	@Override
	public String toString() {
		return "FacultySkill [facultyId=" + facultyId + ", facultyName=" + facultyName + ", facultySkillSet="
				+ facultySkillSet + "]";
	}


	

	
}
