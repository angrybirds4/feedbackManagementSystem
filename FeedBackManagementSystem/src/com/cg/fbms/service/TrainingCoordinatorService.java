package com.cg.fbms.service;

import java.util.Date;

import com.cg.fbms.dao.TrainingCoordinatorDAO;
import com.cg.fbms.dto.TrainingProgram;

public class TrainingCoordinatorService implements ITrainingCoordinatorService{

	TrainingCoordinatorDAO corodinatorDAO = new TrainingCoordinatorDAO();
	
	
	@Override
	public boolean addTrainingSession(TrainingProgram trainingProgram) {
		// TODO Auto-generated method stub
		return corodinatorDAO.addTrainingCourse(trainingProgram);
		
	}
}