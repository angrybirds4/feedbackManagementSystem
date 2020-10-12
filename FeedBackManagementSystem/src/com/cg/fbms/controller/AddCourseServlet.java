package com.cg.fbms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.fbms.dao.CourseMaintenanceDAO;
import com.cg.fbms.dao.ICourseMaintenanceDAO;
import com.cg.fbms.dto.CourseMaster;

public class AddCourseServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		String courseName = request.getParameter("courseName");
		int courseDays = Integer.parseInt(request.getParameter("courseDays"));

		CourseMaster courseMaster = new CourseMaster();

		ICourseMaintenanceDAO addCourseDAO = new CourseMaintenanceDAO();
		if (addCourseDAO.addCourse(courseMaster))
			System.out.println("Course added Successfully");
		else
			System.out.println("Some Error occurred");

	}

}
