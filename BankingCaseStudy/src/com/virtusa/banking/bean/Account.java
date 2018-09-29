package com.virtusa.banking.bean;

import java.util.Date;

public class Account {
	private int accontNo;
	private String customerName;
	private double balance;
	private Date dateOpened;
	public Account() {
	}
	public Account(int accontNo, String customerName, double balance, Date dateOpened) {
		this.accontNo = accontNo;
		this.customerName = customerName;
		this.balance = balance;
		this.dateOpened = dateOpened;
	}
	public int getAccontNo() {
		return accontNo;
	}
	public void setAccontNo(int accontNo) {
		this.accontNo = accontNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}
	
}
