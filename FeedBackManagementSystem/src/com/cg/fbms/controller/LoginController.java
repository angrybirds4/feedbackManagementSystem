package com.cg.fbms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.fbms.dao.ILoginDAO;
import com.cg.fbms.dao.LoginDAOImpl;
import com.cg.fbms.dto.Employee;

@WebServlet("/LoginServlet")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ILoginDAO loginDAO = new LoginDAOImpl();
		
		int employeeId =  Integer.parseInt(request.getParameter("username"));
		String employeePassword = request.getParameter("password");
		
		Employee employeeCredentials = new Employee(employeeId,employeePassword);
		
		try {
			
			boolean isValidEmployee = loginDAO.validateEmployee(employeeCredentials);
			
			System.out.println("Enter employee id : " + employeeId);
			System.out.println("Enter employee password : "+employeePassword);
			
			String role = loginDAO.getEmployeeRole();
			System.out.println("Role of Employee is : "+role);
			
			if(isValidEmployee)
			{
				switch(role)
				{
				case "Participant" :
								response.sendRedirect("ParticpantHomePage.jsp");
								break;
								
				case "Admin" : request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);;
				                break;
				                
				default :
								response.sendRedirect("coordinatorHomePage.jsp");
				                break;
				}
			}
			
			else {
				/*request.setAttribute("ErrorMsg", "User Name or Password is Invalid!");
				request.getRequestDispatcher("welcome.jsp").forward(request, response);*/
				response.sendRedirect("welcome.jsp");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("ErrorMsg", "Sorry can't connect to database.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		
		
		
		
	}

}
