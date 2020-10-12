package com.cg.fbms.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Feedback_Master")
public class FeedbackMaster {
	
	private Date feedbackDate;
	private int facultyId;
	@EmbeddedId
	private TrainingParticipantId trainingParticipantId;

	private int fbCommunicationSkill;
	private int fbClarifyDoubts;
	private int fbTimeManagement;
	private int fbHandoutProvide;
	private int fbNetworkAvailability;
	private String fbComments;
	private String fbSuggestions;
	
	public FeedbackMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedbackMaster(Date feedbackDate, int facultyId, TrainingParticipantId trainingParticipantId,
			int fbCommunicationSkill, int fbClarifyDoubts, int fbTimeManagement, int fbHandoutProvide,
			int fbNetworkAvailability, String fbComments, String fbSuggestions) {
		super();
		this.feedbackDate = feedbackDate;
		this.facultyId = facultyId;
		this.trainingParticipantId = trainingParticipantId;
		this.fbCommunicationSkill = fbCommunicationSkill;
		this.fbClarifyDoubts = fbClarifyDoubts;
		this.fbTimeManagement = fbTimeManagement;
		this.fbHandoutProvide = fbHandoutProvide;
		this.fbNetworkAvailability = fbNetworkAvailability;
		this.fbComments = fbComments;
		this.fbSuggestions = fbSuggestions;
	}

	public Date getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public TrainingParticipantId getTrainingParticipantId() {
		return trainingParticipantId;
	}

	public void setTrainingParticipantId(TrainingParticipantId trainingParticipantId) {
		this.trainingParticipantId = trainingParticipantId;
	}

	public int getFbCommunicationSkill() {
		return fbCommunicationSkill;
	}

	public void setFbCommunicationSkill(int fbCommunicationSkill) {
		this.fbCommunicationSkill = fbCommunicationSkill;
	}

	public int getFbClarifyDoubts() {
		return fbClarifyDoubts;
	}

	public void setFbClarifyDoubts(int fbClarifyDoubts) {
		this.fbClarifyDoubts = fbClarifyDoubts;
	}

	public int getFbTimeManagement() {
		return fbTimeManagement;
	}

	public void setFbTimeManagement(int fbTimeManagement) {
		this.fbTimeManagement = fbTimeManagement;
	}

	public int getFbHandoutProvide() {
		return fbHandoutProvide;
	}

	public void setFbHandoutProvide(int fbHandoutProvide) {
		this.fbHandoutProvide = fbHandoutProvide;
	}

	public int getFbNetworkAvailability() {
		return fbNetworkAvailability;
	}

	public void setFbNetworkAvailability(int fbNetworkAvailability) {
		this.fbNetworkAvailability = fbNetworkAvailability;
	}

	public String getFbComments() {
		return fbComments;
	}

	public void setFbComments(String fbComments) {
		this.fbComments = fbComments;
	}

	public String getFbSuggestions() {
		return fbSuggestions;
	}

	public void setFbSuggestions(String fbSuggestions) {
		this.fbSuggestions = fbSuggestions;
	}

	@Override
	public String toString() {
		return "FeedbackMaster [feedbackDate=" + feedbackDate + ", facultyId=" + facultyId + ", trainingParticipantId="
				+ trainingParticipantId + ", fbCommunicationSkill=" + fbCommunicationSkill + ", fbClarifyDoubts="
				+ fbClarifyDoubts + ", fbTimeManagement=" + fbTimeManagement + ", fbHandoutProvide=" + fbHandoutProvide
				+ ", fbNetworkAvailability=" + fbNetworkAvailability + ", fbComments=" + fbComments + ", fbSuggestions="
				+ fbSuggestions + "]";
	}

	
	
	
	


}