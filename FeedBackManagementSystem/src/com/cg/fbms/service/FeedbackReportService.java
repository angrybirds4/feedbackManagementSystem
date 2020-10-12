package com.cg.fbms.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.fbms.dao.FeedbackReportDAO;
import com.cg.fbms.dao.IFeedbackReportDAO;
import com.cg.fbms.dto.FeedbackMaster;
import com.cg.fbms.dto.TrainingParticipantEnrollment;

public class FeedbackReportService implements IFeedbackReport {
	IFeedbackReportDAO feedbackReportDAO = new FeedbackReportDAO();

	@Override
	public ArrayList<FeedbackMaster> getTrainingProgReport() {
		ArrayList<FeedbackMaster> trainingReport = feedbackReportDAO.getTrainingProgReport();
		return trainingReport;
	}

	@Override
	public ArrayList<FeedbackMaster> getTrainingProgReportByFaculty(int facultyId) {
		ArrayList<FeedbackMaster> trainingRepByFacultyId = feedbackReportDAO.getTrainingProgReportByFaculty(facultyId);
		return trainingRepByFacultyId;
	}

	@Override
	public List<FeedbackMaster> getFeedbackDefaulterReports() {
		List<FeedbackMaster> fbDefaulterReports = feedbackReportDAO.getFeedbackDefaulterReports();
		return fbDefaulterReports;
	}

	@Override
	public List<TrainingParticipantEnrollment> getFbPendingParticipants() {
		List<TrainingParticipantEnrollment> fbPendingParticipants = feedbackReportDAO.getFbPendingParticipants();
		return fbPendingParticipants;
	}

}