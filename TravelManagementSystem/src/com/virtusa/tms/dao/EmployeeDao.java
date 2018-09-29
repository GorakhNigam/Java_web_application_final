package com.virtusa.tms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;
import com.virtusa.tms.beans.Employee;
import com.virtusa.tms.utils.DateParsing;
import com.virtusa.tms.utils.TravelQueries;

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
			System.out.println("Connection Estiblished");
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
			int count = 0;
			try {
				
				pst = conn.prepareStatement(TravelQueries.everyEmpls);
				rs = pst.executeQuery();
				while(rs.next())
					count++;
				
				pst = conn.prepareStatement(TravelQueries.addempl);
				pst.setInt(1,count);
				pst.setString(2, emp.getEmployeeName());
				pst.setString(3,emp.getEmailId());
				pst.setString(4, emp.getSource());
				pst.setString(5, emp.getDestination()/*DateParsing.convertDate(emp.getDoj())*/);
				pst.setString(6, emp.getTravelPurpose());
				pst.setString(7,emp.getTravelMode());
//				pst.setString(9,DateParsing.convertDate(emp.getDateFrom()));
//				pst.setString(10, DateParsing.convertDate(emp.getDateTo()));
				pst.setInt(8, emp.getDuration());
				pst.setDouble(9, 0);
				pst.setString(10, emp.getStatus());
				
				rows = pst.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection();
			System.out.println("AddEmployee dao executed");
			return count;
		}
		public List<Employee> getAllEmpls(String emailId){
			openConnection();
			List<Employee> empList = new ArrayList<Employee>();
			try {
				pst = conn.prepareStatement(TravelQueries.getAllEmpls);
				pst.setString(1, emailId);
				rs = pst.executeQuery();
				while(rs.next()) {
					Employee emp  = new Employee();
					emp.setEmployeeName(rs.getString(2));
					emp.setEmailId(rs.getString(3));
					emp.setSource(rs.getString(4));
					emp.setDestination(rs.getString(5));
					emp.setTravelPurpose(rs.getString(6));
					emp.setTravelMode(rs.getString(7));
					emp.setDuration(rs.getInt(8));
					emp.setTravelExpense(rs.getDouble(9));
					emp.setStatus(rs.getString(10));
//					emp.setDateFrom(rs.getDate(9));
//					emp.setDateTo(rs.getDate(10));
					empList.add(emp);
					
				}
			}
				catch(SQLException e) {
					e.printStackTrace();
				}
				closeConnection();
				return empList;
			}
		
		public Employee getEmpl(String emailId) {
			openConnection();
			Employee emp = null;
			try {
				pst = conn.prepareStatement(TravelQueries.getAllEmpls);
				pst.setString(1, emailId);
				rs = pst.executeQuery();
				while(rs.next()) {
					//Employee emp  = new Employee();
					emp.setEmployeeName(rs.getString(2));
					emp.setEmailId(rs.getString(3));
					emp.setSource(rs.getString(4));
					emp.setDestination(rs.getString(5));
					emp.setTravelPurpose(rs.getString(6));
					emp.setTravelMode(rs.getString(7));
					emp.setTravelExpense(rs.getDouble(8));
					emp.setDuration(rs.getInt(9));
//					emp.setDateFrom(rs.getDate(9));
//					emp.setDateTo(rs.getDate(10));
				}
			}
				catch(SQLException e) {
					e.printStackTrace();
				}
				closeConnection();
				return emp;
		}
		
		public void updateAll(Employee emp) {
			openConnection();
			try {
				pst = conn.prepareStatement(TravelQueries.updateAll);
				pst.setString(1, emp.getEmployeeName());
				pst.setString(2, emp.getSource());
				pst.setString(3, emp.getDestination());
				pst.setString(4, emp.getTravelPurpose());
				pst.setString(5, emp.getTravelMode());
				pst.setInt(6, emp.getDuration());
//				pst.setString(6, DateParsing.convertDate(emp.getDateFrom()));
//				pst.setString(7, DateParsing.convertDate(emp.getDateTo()));
				pst.setString(8, emp.getEmailId());
				
				pst.executeUpdate();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("All fields updated");
			closeConnection();
		}
		public void updateStatus(String status, int serialNo) {
			openConnection();
			
			try {
				pst = conn.prepareStatement(TravelQueries.updateStatus);
				pst.setString(1, status);
				pst.setInt(2, serialNo);
				
				pst.executeUpdate();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("All fields updated");
			closeConnection();
		}
		public void updateExpense(double travelExpense, int serialNo) {
			openConnection();
			try {
				pst = conn.prepareStatement(TravelQueries.updateExpense);
				pst.setDouble(1, travelExpense);
				pst.setInt(2, serialNo);
				
				int row = pst.executeUpdate();
				System.out.println("UpdateExpense Executed"+row);
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			closeConnection();
		}

}
