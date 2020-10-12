package com.cg.fbms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "employee_master")
public class Employee {
	
	@Id
	private int employeeId;
	private String employeeName;
	private String employeePassword;
	private String employeeRole;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Employee(int employeeId, String employeePassword) {
		super();
		this.employeeId = employeeId;
		this.employeePassword = employeePassword;
	}




	public Employee(int employeeId, String employeeName, String employeePassword, String employeeRole) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
		this.employeeRole = employeeRole;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public String getEmployeeName() {
		return employeeName;
	}



	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public String getEmployeePassword() {
		return employeePassword;
	}



	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}



	public String getEmployeeRole() {
		return employeeRole;
	}



	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}



	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePassword="
				+ employeePassword + ", employeeRole=" + employeeRole + "]";
	}
	
	
	

}
