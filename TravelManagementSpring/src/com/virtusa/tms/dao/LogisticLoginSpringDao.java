package com.virtusa.tms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.virtusa.tms.beans.Employee;
import com.virtusa.tms.utils.LogisticQueries;
import com.virtusa.tms.utils.TravelQueries;

@Repository
public class LogisticLoginSpringDao extends JdbcDaoSupport{
	
	@Autowired
	Employee emp;
//	@Autowired
//	EmployeePSS pss;
	@Autowired
	public LogisticLoginSpringDao(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public List <Employee> getAllEmpls(){
		String status = "Approved";
		double travelExpense = 0;
		Object args[] = {status,travelExpense};
		List<Employee> empList = getJdbcTemplate().query(LogisticQueries.review,
		new BeanPropertyRowMapper<Employee>(Employee.class));
		return empList;
	}
	public int updateExpense(double travelExpense, int serialNo) {
		Object args[] = {/*emp.getSalary(),emp.getEmpcode()*/travelExpense,serialNo};
		int row = getJdbcTemplate().update(TravelQueries.updateExpense,args);
		return row;
	}
	
}
