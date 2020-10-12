package com.cg.fbms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.fbms.dao.TrainingCoordinatorDAO;
import com.cg.fbms.dto.TrainingProgram;
import com.cg.fbms.service.ITrainingCoordinatorService;
import com.cg.fbms.service.TrainingCoordinatorService;

@WebServlet("/AddTrainingSessionController")
public class AddTrainingSessionController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ITrainingCoordinatorService addTraining = new TrainingCoordinatorService();

		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int facultyId = Integer.parseInt(request.getParameter("facultyId"));
		Date startDate = null;
		try {
			startDate = new SimpleDateFormat("yyy-MM-dd").parse(request.getParameter("startDate"));
		} catch (ParseException parseExp) {
			// TODO Auto-generated catch block
			parseExp.printStackTrace();
		}

		Date endDate = null;
		try {
			endDate = new SimpleDateFormat("yyy-MM-dd").parse(request.getParameter("endDate"));
		} catch (ParseException parseExp) {

			parseExp.printStackTrace();
		}

		TrainingProgram trainingProgram = new TrainingProgram(courseId, facultyId, startDate, endDate);

		boolean trainingSession = addTraining.addTrainingSession(trainingProgram);

		/*
		 * AddTrainingSessionDAO dao = new AddTrainingSessionDAO();
		 * if(dao.insertData(TrainingP))System.out.println("New Training Course added!"
		 * ); else System.out.println("Fix yo error");
		 */
	}
}
