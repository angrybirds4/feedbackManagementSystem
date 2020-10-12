package com.cg.fbms.dao;

public interface QueryConstants {
	// for facultyMaintenance
	final String GET_ALL_FACULTY_LIST = "SELECT fSkill FROM Faculty fSkill";
	//
	final String GET_ALL_COURSE_LIST = "SELECT course FROM CourseMaster course";

	// for course faculty mapping
	final String GET_ALL_FACULTY_ID_BY_COURSENAME = "SELECT cRFMapping FROM CourseFacultyMapping cRFMapping WHERE cRFMapping.courseId=?";

	// queries for participant
	final String GET_PARTICIPANT_ENROLLMENT_LIST = "SELECT tParticipantEnroll FROM TrainingParticipantEnrollment  WHERE tParticipantEnroll.trainingParticipantId.participantId=?";

	// for feedback master
	final String GET_ALL_FEEDBACK_REPORTS = "SELECT fMaster FROM FeedbackMaster fMaster";
	final String GET_FEEDBACK_REPORTS_BY_FACULTY_ID = "SELECT fMaster from FeedbackMaster fMaster where fMaster.facultyId = :arg1";
	final String GET_FB_PENDING_PARTICIPANTS = "select tParticipantEnroll from TrainingParticipantEnrollment tParticipantEnroll where not exists "
			+ "(select fMaster.id FROM FeedbackMaster fMaster where fMaster.id = tParticipantEnroll.id)";
}