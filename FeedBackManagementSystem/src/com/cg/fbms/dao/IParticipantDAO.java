package com.cg.fbms.dao;

import java.util.List;

import com.cg.fbms.dto.FeedbackMaster;
import com.cg.fbms.dto.TrainingProgram;

public interface IParticipantDAO {

	public List<TrainingProgram> getTrainingProgram(int participantId);

	public boolean provideFeedback(FeedbackMaster participantFeedback);

	public List<FeedbackMaster> getProvidedFeedback(int participantId);

	public List<FeedbackMaster> getDefaultFeedback(int participantId);

}
