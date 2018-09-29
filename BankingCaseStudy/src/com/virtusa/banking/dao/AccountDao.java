package com.virtusa.banking.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;
import com.virtusa.banking.appln.BankingQueries;
import com.virtusa.banking.bean.Account;


public class AccountDao {

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
	public void createAccount(Account acc) {
		openConnection();
		//List<Account> acc = new ArrayList<Account>();
		try {
				int accountNo = 0;
				pst = conn.prepareStatement(BankingQueries.everyAccount);
				rs = pst.executeQuery();
				while(rs.next())
					accountNo++;
				pst = conn.prepareStatement(BankingQueries.createAccount);
				
				//Account empac = new Account();
				pst.setInt(1,accountNo);
				//empac.setAccontNo(accountNo);
				pst.setString(2,acc.getCustomerName());
				//empac.setCustomerName(customerName);
				pst.setDouble(3, acc.getBalance());
				//empac.setBalance(balance);
				pst.setString(4, com.virtusa.banking.util.DateParsing.convertDate(acc.getDateOpened()));
				//empac.setDateOpened(dateOpened);
				pst.executeUpdate();
				//acc.add(empac);
				pst = conn.prepareStatement(BankingQueries.createDaybook);
				pst.setInt(1,accountNo);
				pst.setString(2, com.virtusa.banking.util.DateParsing.convertDate(acc.getDateOpened()));
				pst.setString(3,"debited");
				pst.setString(4, "gift");
				pst.setDouble(5,acc.getBalance());
				pst.setDouble(6,acc.getBalance());
				pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		//return balance;
	}
	public double deposite(int accountNo, Date transDate, String tranType, String Description, double amount) {
		openConnection();
		
		try {
			
			pst = conn.prepareStatement(BankingQueries.getAccount);	
			pst.setInt(1, accountNo);
			rs = pst.executeQuery();
			rs.next();
			double bal = rs.getDouble("balance");
			pst = conn.prepareStatement(BankingQueries.deposite);
			pst.setDouble(1, amount+bal);

			pst.setInt(2, accountNo);
			pst.executeUpdate();
			System.out.println("deposite method executed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("deposite method not executed");
			e.printStackTrace();
		}
		closeConnection();
		return 0;
	}
	public int withdraw(int accountNo, Date transDate, String tranType, String Description, double amount) {
openConnection();
		
		try {
			pst = conn.prepareStatement(BankingQueries.getAccount);	
			pst.setInt(1, accountNo);
			rs = pst.executeQuery();
			rs.next();
			double bal = rs.getDouble("balance");
			pst = conn.prepareStatement(BankingQueries.deposite);
			pst.setDouble(1, bal-amount);

			pst.setInt(2, accountNo);
			pst.executeUpdate();
			System.out.println("withdraw method executed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("deposite method not executed");
			e.printStackTrace();
		}
		closeConnection();
		return 0;
	}
	public void checkBalance(int accountNo) {
		openConnection();
		try {
			pst = conn.prepareStatement(BankingQueries.checkBalance);
			pst.setInt(1, accountNo);
			rs = pst.executeQuery();
			rs.next();
			System.out.println(rs.getDouble(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
}
