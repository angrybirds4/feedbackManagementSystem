package com.cg.fbms.dao;

import com.cg.fbms.dto.Employee;

public interface ILoginDAO {

	public boolean validateEmployee(Employee employee);

	public String getEmployeeRole();

	public String getEmployeeName();

}
