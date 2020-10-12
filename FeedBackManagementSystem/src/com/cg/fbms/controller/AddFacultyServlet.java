package com.cg.fbms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.fbms.dto.Faculty;
import com.cg.fbms.service.FacultymaintenanceService;
import com.cg.fbms.service.IFacutlyMaintenance;

@WebServlet("/AddFacultyServlet")
public class AddFacultyServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = null;

		String facultyName = request.getParameter("facultyName");
		String facultySkillSet = request.getParameter("facultySkillSet");
		System.out.println(facultyName + " " + facultySkillSet);
		IFacutlyMaintenance facultyMaintenance = new FacultymaintenanceService();

		try {
			boolean addingStatus = facultyMaintenance.addFaculty(new Faculty(facultyName, facultySkillSet));
			if (addingStatus) {
				request.setAttribute("successMessage", "Faculty added successfully");
				dispatcher = request.getRequestDispatcher("adminHomePage.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Some error occurred, please verify all details");
				dispatcher = request.getRequestDispatcher("addFaculty.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("error", "Sorry can't connect to databse");
			dispatcher = request.getRequestDispatcher("errorPage.jsp");
			dispatcher.include(request, response);
		}

	}
}
