package com.virtusa.empls.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

import com.virtusa.empls.beans.DateParsing;
import com.virtusa.empls.beans.Employee;
import com.virtusa.empls.utils.EmplDBQueries;

public class EmployeeDao {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public void openConnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			String url = "jdbc:mysql://localhost:3306/gorakh";
			String user = "root";
			String pass = "root";
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int addEmployee(Employee emp) {
		openConnection();
		int rows = 0;
		try {
			pst = (PreparedStatement) conn.prepareStatement(EmplDBQueries.addempl);
			pst.setInt(1,emp.getEmpcode());
			pst.setString(2, emp.getEmpname());
			pst.setString(3,emp.getJob());
			pst.setDouble(4, emp.getSalary());
			pst.setDate(5, DateParsing.convertDate(emp.getDoj()));
			rows = pst.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return rows;
	}
	public List<Employee> getAllEmpls(){
		openConnection();
		List<Employee> empList = new ArrayList<Employee>();
		try {
			pst = conn.prepareStatement(EmplDBQueries.getAllEmpls);
			rs = pst.executeQuery();
			while(rs.next()) {
				Employee emp  = new Employee();
				emp.setEmpcode(rs.getInt(1));
				emp.setEmpname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSalary(rs.getDouble(4));
				emp.setDoj(rs.getDate(5).toString());
				empList.add(emp);
				
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
			closeConnection();
			return empList;
		}
		
		public Employee getEmpl(int code) {
			openConnection();
			Employee emp = null;
			try {
				pst = conn.prepareStatement(EmplDBQueries.getEmpl);
				pst.setInt(1, code);
				rs = pst.executeQuery();
				if(rs.next()) {
					emp  = new Employee();
					emp.setEmpcode(rs.getInt(1));
					emp.setEmpname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDoj(rs.getDate(5).toString());
					
					
				}
			}
				catch(SQLException e) {
					e.printStackTrace();
				}
				closeConnection();
				return emp;
		}
	
		public void delEmployee(int code) {
			openConnection();
			try {
				pst = conn.prepareStatement(EmplDBQueries.delEmp);
				pst.setInt(1, code);
				pst.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("deleted");
			closeConnection();
		}
		public void getUpdate (double salary,int code) {
			openConnection();
			try {
				pst = conn.prepareStatement(EmplDBQueries.getUpdate);
				pst.setDouble(1, salary);
				pst.setInt(2, code);
				pst.executeUpdate();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("updated");
			closeConnection();
			
		}
}