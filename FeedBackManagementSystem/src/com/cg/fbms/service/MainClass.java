package com.cg.fbms.service;

import com.cg.fbms.dao.ILoginDAO;
import com.cg.fbms.dto.CourseFacultyMapping;
import com.cg.fbms.dto.CourseMaster;
import com.cg.fbms.dto.Employee;
import com.cg.fbms.dto.Faculty;

import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		// for authentication of employee

		/*
		 * Employee employee = null; employee = new Employee(sc.nextInt(),sc.next());
		 * LoginEmployeeService loginEmployee = new LoginEmployeeService();
		 * if(loginEmployee.loginAuthentication(employee)) {
		 * System.out.println("Login Successfully"); }
		 * 
		 * else System.out.println("Login Failed");
		 * 
		 */

		// starting of faculty
		FacultymaintenanceService faculty = new FacultymaintenanceService();
		CourseMaintenanceService course = new CourseMaintenanceService();
		// FacultymaintenanceService faculty1 = new FacultymaintenanceService();
		faculty.addFaculty(new Faculty("Rajesh", "java,python,c,c++,javascript"));
		faculty.addFaculty(new Faculty("keerthi", "c,c++"));
		faculty.addFaculty(new Faculty("Sushantika", "java,javascript"));
		/*
		 * if(faculty.addFaculty(new Faculty(1,"Abhishek","java,python"))) {
		 * System.out.println("Successfully Inserted"); } else
		 * System.out.println("Failed");
		 */

		// faculty.getAllFacultyList();
		// System.out.println(faculty.getFacultySkillById(1));
		// System.out.println(faculty1.getAllFacultyId());
		// System.out.println(faculty.getMappedFacultyWithCourse(1));
		/*
		 * System.out.println(faculty.courseFacultyMapping(new
		 * CourseFacultyMapping(1,1))); faculty.courseFacultyMapping(new
		 * CourseFacultyMapping(1,2)); faculty.courseFacultyMapping(new
		 * CourseFacultyMapping(1,3)); faculty.courseFacultyMapping(new
		 * CourseFacultyMapping(2,2)); faculty.courseFacultyMapping(new
		 * CourseFacultyMapping(2,3));
		 */
		// System.out.println(faculty.getFacultyNotMappedWithCourse(new
		// CourseMaster(4,"javascript")));

		// for course
		// System.out.println(course.getCourseById(1));

	}

}
