package com.cg.fbms.service;

import java.util.List;

import com.cg.fbms.dto.FeedbackMaster;
import com.cg.fbms.dto.TrainingProgram;

public interface IParticipantService {
	
	public List<TrainingProgram> enrollTrainingProgram(int participantId);
	public boolean provideFeedback(FeedbackMaster participantFeedback);
	public List<FeedbackMaster> getProvidedFeedback(int participantId);
	public List<FeedbackMaster> getDefaultFeedback(int participantId);

}
