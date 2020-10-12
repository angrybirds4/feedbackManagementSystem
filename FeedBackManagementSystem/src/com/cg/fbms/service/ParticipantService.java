package com.cg.fbms.service;

import java.util.List;

import com.cg.fbms.dao.IParticipantDAO;
import com.cg.fbms.dao.ParticipantDAO;
import com.cg.fbms.dto.FeedbackMaster;
import com.cg.fbms.dto.TrainingProgram;

public class ParticipantService implements IParticipantService {
	
	IParticipantDAO participantDAO =new ParticipantDAO();
	
	@Override
	public List<TrainingProgram> enrollTrainingProgram(int participantId) {
		
		return participantDAO.getTrainingProgram(participantId);
	}
	
	@Override
	public boolean provideFeedback(FeedbackMaster participantFeedback) {
		// TODO Auto-generated method stub
		return participantDAO.provideFeedback(participantFeedback);
	}
	
	@Override
	public List<FeedbackMaster> getProvidedFeedback(int participantId) {
		// TODO Auto-generated method stub
		return participantDAO.getProvidedFeedback(participantId);
	}
	
	@Override
	public List<FeedbackMaster> getDefaultFeedback(int participantId) {
		// TODO Auto-generated method stub
		return  participantDAO.getDefaultFeedback(participantId);
	}
	
	

}
