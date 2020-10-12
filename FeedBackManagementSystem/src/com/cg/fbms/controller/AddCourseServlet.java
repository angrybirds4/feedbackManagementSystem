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
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer courseId = Integer.parseInt(request.getParameter("courseId"));
		String courseName = request.getParameter("courseName");
		Integer courseDays = Integer.parseInt(request.getParameter("courseDays"));
		
		CourseMaster cm = new CourseMaster();
		
		ICourseMaintenanceDAO acdao = new CourseMaintenanceDAO();
		if(acdao.addCourse(cm))System.out.println("Course added Successfully");
		else System.out.println("Some Error occurred");
		
	}

}
