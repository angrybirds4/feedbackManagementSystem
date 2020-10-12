package com.cg.fbms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.fbms.dto.FeedbackMaster;
import com.cg.fbms.dto.TrainingParticipantEnrollment;
import com.cg.fbms.dto.TrainingParticipantId;
import com.cg.fbms.utility.JPAUtility;


public class FeedbackReportDAO implements IFeedbackReportDAO, QueryConstants {

	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;

	@Override
	public ArrayList<FeedbackMaster> getTrainingProgReport() {
		
		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		ArrayList<FeedbackMaster> trainingReport = null;
		
		try {
			trainingReport = (ArrayList<FeedbackMaster>) manager.createQuery(GET_ALL_FEEDBACK_REPORTS, FeedbackMaster.class).getResultList();
		} 
		catch (PersistenceException e) {
			System.err.println(e.getMessage());
		} 
		finally {
			manager.close();
			
		}
		return trainingReport;
		
	}
	
	


	@Override
	public ArrayList<FeedbackMaster> getTrainingProgReportByFaculty(int facultyId) {
		
		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		ArrayList<FeedbackMaster> trainingRepByFacultyId = null;
		
		try {
			Query query = manager.createQuery(GET_FEEDBACK_REPORTS_BY_FACULTY_ID, FeedbackMaster.class);
			query.setParameter("arg1", facultyId);
			trainingRepByFacultyId = (ArrayList<FeedbackMaster>) query.getResultList();
			
		} 
		catch (PersistenceException e) {
			System.err.println(e.getMessage());
			return null;
		} 
		finally {
			manager.close();
			
		}
		return trainingRepByFacultyId;
	}


	@Override
	public List<FeedbackMaster> getFeedbackDefaulterReports() {
		List<FeedbackMaster> feedbackReport = getTrainingProgReport();
		List<FeedbackMaster> defaultFeedbackList = new ArrayList<FeedbackMaster>();
		for(FeedbackMaster defaultFeedback: feedbackReport)	{
			if(defaultFeedback != null) {
				if(defaultFeedback.getFbCommunicationSkill()== 0 || defaultFeedback.getFbClarifyDoubts() == 0
					|| defaultFeedback.getFbHandoutProvide() == 0 || defaultFeedback.getFbNetworkAvailability()==0
					|| defaultFeedback.getFbTimeManagement()== 0) {
					defaultFeedbackList.add(defaultFeedback);
				}
			}
		}
		return defaultFeedbackList;
	}
	
	public List<TrainingParticipantEnrollment> getFbPendingParticipants() {
		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		List<TrainingParticipantEnrollment> fbPendingParticipantList = null;
		
		try {
			fbPendingParticipantList = (List<TrainingParticipantEnrollment>) manager.createQuery(GET_FB_PENDING_PARTICIPANTS).getResultList();
			
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());

		} 
		finally {
			manager.close();
			
		}
		return fbPendingParticipantList;
		
	}

}