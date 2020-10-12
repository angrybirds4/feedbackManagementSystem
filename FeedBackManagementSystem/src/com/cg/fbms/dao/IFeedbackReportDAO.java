package com.cg.fbms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cg.fbms.dto.FeedbackMaster;
import com.cg.fbms.dto.TrainingParticipantEnrollment;
import com.cg.fbms.dto.TrainingParticipantId;

public interface IFeedbackReportDAO {
	
	public ArrayList<FeedbackMaster> getTrainingProgReport();
	
	public ArrayList<FeedbackMaster> getTrainingProgReportByFaculty(int facultyId);
	
	public List<FeedbackMaster> getFeedbackDefaulterReports();
	
	public List<TrainingParticipantEnrollment> getFbPendingParticipants();

}