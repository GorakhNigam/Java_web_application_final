package com.virtusa.banking.bean;

public class DayBook {
	private int accountNo;
	private String transDate;
	private String transType;
	private String description;
	private double amount;
	private double balance;
	public DayBook() {
	}
	public DayBook(int accountNo, String transDate, String transType, String description, double amount,
			double balance) {
		this.accountNo = accountNo;
		this.transDate = transDate;
		this.transType = transType;
		this.description = description;
		this.amount = amount;
		this.balance = balance;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
