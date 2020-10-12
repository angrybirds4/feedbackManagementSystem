package com.cg.fbms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.fbms.dto.FeedbackMaster;
import com.cg.fbms.dto.TrainingParticipantId;
import com.cg.fbms.service.IParticipantService;
import com.cg.fbms.service.ParticipantService;

class FeedbackEntryTest {

	IParticipantService participantService = null;

	@BeforeEach
	public void setUp() {
		participantService = new ParticipantService();
	}

	@Test
	void test1() {
		TrainingParticipantId trainingParticipantId = new TrainingParticipantId(102, 41481);
		Date joinDate = null;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			joinDate = format.parse("10-12-2020");
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

		FeedbackMaster participantFeedback = new FeedbackMaster(joinDate, 101, trainingParticipantId, 0, 0, 4, 1, 1,
				"uqgdiqwdi", "hqqwsq");
		boolean actualResult = participantService.provideFeedback(participantFeedback);
		boolean expectedResult = false;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void test2() {
		TrainingParticipantId trainingParticipantId = new TrainingParticipantId(102, 41481);
		Date joinDate = null;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			joinDate = format.parse("12-10-2020");
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

		FeedbackMaster participantFeedback = new FeedbackMaster(joinDate, 101, trainingParticipantId, 3, 2, 4, 1, 0,
				"uqgdiqwdi", "hqqwsq");
		boolean actualResult = participantService.provideFeedback(participantFeedback);
		boolean expectedResult = true;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void test3() {
		TrainingParticipantId trainingParticipantId = new TrainingParticipantId(102, 41481);
		Date joinDate = null;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			joinDate = format.parse("10-12-2020");
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

		FeedbackMaster participantFeedback = new FeedbackMaster(joinDate, 101, trainingParticipantId, 0, 0, 4, 1, 1,
				"uqgdiqwdi", "hqqwsq");
		boolean actualResult = participantService.provideFeedback(participantFeedback);
		boolean expectedResult = true;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void test4() {
		TrainingParticipantId trainingParticipantId = new TrainingParticipantId(101, 41481);
		Date joinDate = null;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			joinDate = format.parse("10-12-2020");
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

		FeedbackMaster participantFeedback = new FeedbackMaster(joinDate, 101, trainingParticipantId, 4, 3, 0, 0, 0,
				"uqgdiqwdi", "hqqwsq");
		boolean actualResult = participantService.provideFeedback(participantFeedback);
		boolean expectedResult = true;
		assertEquals(expectedResult, actualResult);
	}

}
