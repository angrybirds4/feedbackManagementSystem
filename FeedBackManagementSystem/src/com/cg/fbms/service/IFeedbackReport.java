package com.cg.fbms.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.fbms.dto.FeedbackMaster;
import com.cg.fbms.dto.TrainingParticipantEnrollment;

public interface IFeedbackReport {

	public ArrayList<FeedbackMaster> getTrainingProgReport();
	
	public ArrayList<FeedbackMaster> getTrainingProgReportByFaculty(int facultyId);
	
	public List<FeedbackMaster> getFeedbackDefaulterReports();
	
	public List<TrainingParticipantEnrollment> getFbPendingParticipants();
	
}