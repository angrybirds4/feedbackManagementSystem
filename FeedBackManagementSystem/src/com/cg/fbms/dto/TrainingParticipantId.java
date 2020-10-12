package com.cg.fbms.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class TrainingParticipantId implements Serializable {
	
	
	private int trainingCode;
	private int participantId;
	
	public TrainingParticipantId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public TrainingParticipantId(int trainingCode, int participantId) {
		super();
		this.trainingCode = trainingCode;
		this.participantId = participantId;
	}


	public int getTrainingCode() {
		return trainingCode;
	}


	public void setTrainingCode(int trainingCode) {
		this.trainingCode = trainingCode;
	}


	public int getParticipantId() {
		return participantId;
	}


	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}


	@Override
	public String toString() {
		return "TrainingParticipantId [trainingCode=" + trainingCode + ", participantId=" + participantId + "]";
	}
	
	
	
	
	
	

}
