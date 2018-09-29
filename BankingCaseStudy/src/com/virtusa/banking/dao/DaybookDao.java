package com.virtusa.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
import com.virtusa.banking.appln.BankingQueries;

public class DaybookDao {
	
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
	
	public void getStatement(int accountno) {
		openConnection();
		//int rows = 0;
		try {
			pst = conn.prepareStatement(BankingQueries.checkBalance);
			pst.setInt(1, accountno);
			rs = pst.executeQuery();
			rs.next();
			 do{
				System.out.println(rs.getInt(1)+" "+/*rs.getDate(2).toString()+*/" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getDouble(5)+" "+rs.getDouble(6));
			}while(rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
}
