package com.cg.fbms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.cg.fbms.dto.FeedbackMaster;
import com.cg.fbms.dto.TrainingParticipantEnrollment;
import com.cg.fbms.dto.TrainingProgram;
import com.cg.fbms.service.IParticipantService;
import com.cg.fbms.service.ParticipantService;
import com.cg.fbms.utility.JPAUtility;

public class ParticipantDAO implements IParticipantDAO{
	
	public static List<TrainingParticipantEnrollment> getParticipantEnrollemntList(int participantId,EntityManager manager){
	
		String selectQuery = "select t from TrainingParticipantEnrollment t where t.id.participantId=?";
		TypedQuery<TrainingParticipantEnrollment> query = manager.createQuery(selectQuery,TrainingParticipantEnrollment.class);
		query.setParameter(1, participantId);
		
		List<TrainingParticipantEnrollment> list = query.getResultList();
		return list;
	}
	
	@Override
	public List<TrainingProgram> getTrainingProgram(int participantId) {
		
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		List<TrainingProgram> listProgram=new ArrayList<TrainingProgram>();

		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		System.out.println(participantId);
		
		List<TrainingParticipantEnrollment> list = ParticipantDAO.getParticipantEnrollemntList(participantId,manager);
		for(TrainingParticipantEnrollment program :list)
		{
			TrainingProgram getProgram = manager.find(TrainingProgram.class,program.getId().getTrainingCode());
			listProgram.add(getProgram);
		}
		return listProgram;
	}
	
	
	@Override
	public boolean provideFeedback(FeedbackMaster participantFeedback ) {
		// TODO Auto-generated method stub
		
		
		if(participantFeedback.getFbClarifyDoubts()==0 || participantFeedback.getFbCommunicationSkill()==0) {
			return false;
		}
		 
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		
		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
	
		try {
			manager.persist(participantFeedback);
			transaction.commit();
			return true;
		} 
		catch (PersistenceException e) {
			transaction.rollback();
			System.out.println(e.getMessage());
			return false;
		} 
		finally {
			manager.close();
		}
	}
	
	@Override
	public List<FeedbackMaster> getProvidedFeedback(int participantId) {
		
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		List<FeedbackMaster> providedFeedback =new ArrayList<FeedbackMaster>();
		
		factory = JPAUtility.getFactory();
		manager = factory.createEntityManager();
		
		List<TrainingParticipantEnrollment> list = ParticipantDAO.getParticipantEnrollemntList(participantId,manager);
		
		for(TrainingParticipantEnrollment program :list)
		{
			System.out.println(program.getId().getParticipantId()+" "+program.getId().getTrainingCode());
			FeedbackMaster getProvidedFeedback = manager.find(FeedbackMaster.class,program.getId());
			providedFeedback.add(getProvidedFeedback);
		}
	
		return providedFeedback;
	}
	
	@Override
	public List<FeedbackMaster> getDefaultFeedback(int participantId) {
		// TODO Auto-generated method stub
		IParticipantService getProvidedFeedback = new ParticipantService();
		List<FeedbackMaster> providedFeedbackList = getProvidedFeedback.getProvidedFeedback(participantId);
		List<FeedbackMaster> defaultFeedbackList = new ArrayList<FeedbackMaster>();
		for(FeedbackMaster defaultFeedback:providedFeedbackList)
		{
			if(defaultFeedback != null) {
			if(defaultFeedback.getFbHandoutProvide() == 0 || defaultFeedback.getFbNetworkAvailability()==0
					|| defaultFeedback.getFbTimeManagement()==0)
				{
				defaultFeedbackList.add(defaultFeedback);
				}
			}
		}
		return defaultFeedbackList;
	}

}
