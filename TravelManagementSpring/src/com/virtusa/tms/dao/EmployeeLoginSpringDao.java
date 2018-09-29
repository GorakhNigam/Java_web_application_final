package com.virtusa.tms.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.virtusa.tms.beans.Employee;
import com.virtusa.tms.beans.EmployeeLogin;
import com.virtusa.tms.utils.LoginQueries;
import com.virtusa.tms.utils.TravelQueries;

@Repository
public class EmployeeLoginSpringDao extends JdbcDaoSupport{
	@Autowired
	Employee emp;
//	@Autowired
//	EmployeePSS pss;
	@Autowired
	public EmployeeLoginSpringDao(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
	}

	public EmployeeLogin getPass(EmployeeLogin emplogin) {
		Object args[] = {emplogin.getUsername()};
		EmployeeLogin empLogin = getJdbcTemplate().queryForObject(LoginQueries.pass,args,new BeanPropertyRowMapper<EmployeeLogin>(EmployeeLogin.class));
				return empLogin;
	}
	
	public int addEmployee(Employee empl) {
		List<Employee> empList = getJdbcTemplate().query(TravelQueries.everyEmpls,
				new BeanPropertyRowMapper<Employee>(Employee.class));
		int count = 0;
		for(Employee emp:empList) {
			count++;
		}
		String status = "Not Reviewed";
		Object args[] = {count,empl.getEmployeeName(), empl.getEmailId(),empl.getSource(),empl.getDestination(),empl.getTravelPurpose(),empl.getTravelMode(),status};
		
		int row = getJdbcTemplate().update(TravelQueries.addempl,args);
		return row;
	}
	
	public List <Employee> getAllEmpls(){
		List<Employee> empList = getJdbcTemplate().query(TravelQueries.viewPrevPlan,
		new BeanPropertyRowMapper<Employee>(Employee.class));
		return empList;
	}
	
	public Employee getEmp(int code) {
		Object args[] = {code};
		Employee emp = getJdbcTemplate().queryForObject(TravelQueries.getAllEmpls,args,new BeanPropertyRowMapper<Employee>(Employee.class));
		return emp;
	}
	
	public int updateAll(Employee empl) {
		Object args[] = {empl.getEmployeeName(),empl.getEmailId(),empl.getSource(),empl.getDestination(),empl.getTravelPurpose(),empl.getTravelMode(),empl.getDuration(),empl.getSerialNo()};
		int row = getJdbcTemplate().update(TravelQueries.updateAll,args);
		return row;
	}
	

	public int updateStatus(String status, int serialNo) {
		Object args[] = {/*emp.getSalary(),emp.getEmpcode()*/status,serialNo};
		int row = getJdbcTemplate().update(TravelQueries.updateStatus,args);
		return row;
	}
	
	public int updateExpense(double travelExpense, int serialNo) {
		Object args[] = {/*emp.getSalary(),emp.getEmpcode()*/travelExpense,serialNo};
		int row = getJdbcTemplate().update(TravelQueries.updateExpense,args);
		return row;
	}
	
}


