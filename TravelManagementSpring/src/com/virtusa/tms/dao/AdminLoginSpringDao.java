package com.virtusa.tms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.virtusa.tms.beans.Employee;
import com.virtusa.tms.utils.AdminQueries;
import com.virtusa.tms.utils.TravelQueries;

@Repository
public class AdminLoginSpringDao extends JdbcDaoSupport{
	@Autowired
	Employee emp;
//	@Autowired
//	EmployeePSS pss;
	@Autowired
	public AdminLoginSpringDao(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
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
		String status = "Not Reviewed";
		Object args[] = {status};
		List<Employee> empList = getJdbcTemplate().query(AdminQueries.review,args,new BeanPropertyRowMapper<Employee>(Employee.class));
		//return emp;
//		List<Employee> empList = getJdbcTemplate().query(AdminQueries.review,
//		new BeanPropertyRowMapper<Employee>(Employee.class));
		return empList;
	}
	
//	public int delete(int code) {
//		Object args[] = {code};
//		int row = getJdbcTemplate().update(EmplDBQueries.delEmp,args);
//		return row;
//	}
	public int updateStatus(String status, int serialNo) {
		Object args[] = {/*emp.getSalary(),emp.getEmpcode()*/status,serialNo};
		int row = getJdbcTemplate().update(TravelQueries.updateStatus,args);
		return row;
	}
	
//	public int updateExpense(double travelExpense, int serialNo) {
//		Object args[] = {/*emp.getSalary(),emp.getEmpcode()*/travelExpense,serialNo};
//		int row = getJdbcTemplate().update(TravelQueries.updateExpense,args);
//		return row;
//	}
	
//	public int updateEmpls(Employee empl) {
//		Object args[] = {empl.getEmpname(),empl.getJob(),empl.getSalary(),empl.getEmpcode()};
//		int row = getJdbcTemplate().update(EmplDBQueries.getUpdate,args);
//		return row;
//	}
	
//	public Employee getEmp(int code) {
//		Object args[] = {code};
//		Employee emp = getJdbcTemplate().queryForObject(EmplDBQueries.getEmpl,args,new BeanPropertyRowMapper<Employee>(Employee.class));
//		return emp;
//	}
}

