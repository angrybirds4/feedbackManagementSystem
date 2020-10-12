package com.cg.fbms.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Training_Participant_Enrollment")
public class TrainingParticipantEnrollment {
	@Id
	//@GeneratedValue
	@EmbeddedId
	TrainingParticipantId id;
	

	public TrainingParticipantEnrollment() {
		// TODO Auto-generated constructor stub
	}

	

	public TrainingParticipantEnrollment(TrainingParticipantId id) {
		super();
		this.id = id;
	}



	public TrainingParticipantId getId() {
		return id;
	}


	public void setId(TrainingParticipantId id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "TrainingParticipantEnrollment [id=" + id + "]";
	}
	
	
	

}
