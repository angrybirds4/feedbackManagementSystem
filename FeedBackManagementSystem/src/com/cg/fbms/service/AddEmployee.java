package com.cg.fbms.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.persistence.EntityManagerFactory;

import com.cg.fbms.dao.EmployeeDAO;
import com.cg.fbms.dao.FeedbackReportDAO;
import com.cg.fbms.dao.IEmployeeDAO;
import com.cg.fbms.dao.IFeedbackReportDAO;
import com.cg.fbms.dto.Employee;
import com.cg.fbms.dto.FeedbackMaster;

public class AddEmployee {
	
	public static int generateRandomId()
	{
		int m=(int)Math.pow(10,4);
		int random_id= m+ new Random().nextInt(9*m);
		return random_id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IEmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee=null;
		boolean id=false;
		
	   
		
		
		/*employee = new Employee(generateRandomId(),"Mubeena","mubeena123","Co-ordinator");
		id = employeeDAO.addEmployee(employee);
		System.out.println("employee has inserted with the id: " + id);
		
		employee = new Employee(generateRandomId(),"Abhishek Kumar","abhi123","Admin");
		id = employeeDAO.addEmployee(employee);
		System.out.println("employee has inserted with the id: " + id);
		
		employee = new Employee(generateRandomId(),"Rajesh Kumar","raj123","Participant");
		id = employeeDAO.addEmployee(employee);
		System.out.println("employee has inserted with the id: " + id);
		
		
		employee = new Employee(generateRandomId(),"Shushanthika","shushanthika123","Participant");
		id = employeeDAO.addEmployee(employee);
		System.out.println("employee has inserted with the id: " + id);
		
/*employee = new Employee(generateRandomId(),"Keerthi","keerthi123","Participant");
>>>>>>> branch 'master' of https://github.com/rajesh226-gif/feedbackManagementSystem.git
		id = employeeDAO.addEmployee(employee);
		System.out.println("employee has inserted with the id: " + id);*/
		
		IFeedbackReportDAO feedbackReportDAO = new FeedbackReportDAO();
		ArrayList<FeedbackMaster> allFeedbacks = feedbackReportDAO.getTrainingProgReport();
		
		System.out.println(Arrays.toString(allFeedbacks.toArray()));
		
		System.out.println("By TrainingParticipantId");

		ArrayList<FeedbackMaster> allFeedbacksById = feedbackReportDAO.getTrainingProgReportByFaculty(101);
		
		System.out.println(Arrays.toString(allFeedbacksById.toArray()));
	}

}
