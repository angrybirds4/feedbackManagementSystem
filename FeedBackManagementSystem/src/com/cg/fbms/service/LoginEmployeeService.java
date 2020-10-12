package com.cg.fbms.service;

import com.cg.fbms.dao.EmployeeDAO;
import com.cg.fbms.dao.ILoginDAO;
import com.cg.fbms.dao.LoginDAOImpl;
import com.cg.fbms.dto.Employee;

public class LoginEmployeeService {

	public boolean loginAuthentication(Employee employee) {

		ILoginDAO loginDao = new LoginDAOImpl();
		boolean loginStatus = loginDao.validateEmployee(employee);
		return loginStatus;

	}

}
