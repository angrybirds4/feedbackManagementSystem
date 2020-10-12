package com.cg.fbms.dto;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Training_Participant_Enrollment")
public class TrainingParticipantEnrollment {

	@EmbeddedId
	TrainingParticipantId trainingParticipantId;
	

	public TrainingParticipantEnrollment() {
		// TODO Auto-generated constructor stub
	}


	public TrainingParticipantId getTrainingParticipantId() {
		return trainingParticipantId;
	}


	public void setTrainingParticipantId(TrainingParticipantId trainingParticipantId) {
		this.trainingParticipantId = trainingParticipantId;
	}


	@Override
	public String toString() {
		return "TrainingParticipantEnrollment [trainingParticipantId=" + trainingParticipantId + "]";
	}

	

	
	
	

}
