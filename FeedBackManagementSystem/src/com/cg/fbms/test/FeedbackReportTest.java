package com.cg.fbms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.fbms.dto.FeedbackMaster;
import com.cg.fbms.dto.TrainingParticipantEnrollment;
import com.cg.fbms.service.FeedbackReportService;
import com.cg.fbms.service.IFeedbackReport;

class FeedbackReportTest {

	IFeedbackReport feedbackReportService;
	
	@BeforeEach
	public void setUp() {
		feedbackReportService = new FeedbackReportService();
	}
	
	
	@Test
	void getTrainingProgReportTest() {
		ArrayList<FeedbackMaster> actualResult = feedbackReportService.getTrainingProgReport();
		String expectedResult = "[FeedbackMaster [id=TrainingParticipantId [trainingCode=1002, participantId=101], fbCommunicationSkill=0, fbClarifyDoubts=5, fbTimeManagement=5, fbHandoutProvide=5, fbNetworkAvailability=5, fbComments=Good, fbSuggestions=Good], FeedbackMaster [id=TrainingParticipantId [trainingCode=1003, participantId=101], fbCommunicationSkill=0, fbClarifyDoubts=0, fbTimeManagement=5, fbHandoutProvide=5, fbNetworkAvailability=5, fbComments=Good, fbSuggestions=Excellent]]";
		assertEquals(expectedResult, actualResult.toString());
	}

	@Test
	void getTrainingProgReportByFacultyTest() {
		ArrayList<FeedbackMaster> actualResult = feedbackReportService.getTrainingProgReportByFaculty(5005);
		String expectedResult = "[FeedbackMaster [id=TrainingParticipantId [trainingCode=1002, participantId=101], fbCommunicationSkill=0, fbClarifyDoubts=5, fbTimeManagement=5, fbHandoutProvide=5, fbNetworkAvailability=5, fbComments=Good, fbSuggestions=Good]]";
		assertEquals(expectedResult, actualResult.toString());
		
		ArrayList<FeedbackMaster> actualResult2 = feedbackReportService.getTrainingProgReportByFaculty(4);
		String expectedResult2 = "[]";
		assertEquals(expectedResult2, actualResult2.toString());
	}
	
	@Test
	void getFeedbackDefaulterReportsTest() {
		List<FeedbackMaster> actualResult = feedbackReportService.getFeedbackDefaulterReports();
		String expectedResult = "[FeedbackMaster [id=TrainingParticipantId [trainingCode=1002, participantId=101], fbCommunicationSkill=0, fbClarifyDoubts=5, fbTimeManagement=5, fbHandoutProvide=5, fbNetworkAvailability=5, fbComments=Good, fbSuggestions=Good], FeedbackMaster [id=TrainingParticipantId [trainingCode=1003, participantId=101], fbCommunicationSkill=0, fbClarifyDoubts=0, fbTimeManagement=5, fbHandoutProvide=5, fbNetworkAvailability=5, fbComments=Good, fbSuggestions=Excellent]]";
		assertEquals(expectedResult, actualResult.toString());
	}
	
	@Test
	void getFbPendingParticipantsTest() {
		List<TrainingParticipantEnrollment> actualResult = feedbackReportService.getFbPendingParticipants();
		String expectedResult = "[TrainingParticipantEnrollment [id=TrainingParticipantId [trainingCode=1001, participantId=101]], TrainingParticipantEnrollment [id=TrainingParticipantId [trainingCode=1001, participantId=5005]]]";
		assertEquals(expectedResult, actualResult.toString());
	}

}