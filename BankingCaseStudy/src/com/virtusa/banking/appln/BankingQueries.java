package com.virtusa.banking.appln;

public class BankingQueries {
	
	public static String everyAccount = "select * from Account";
	public static String createAccount = "insert into Account values(?,?,?,?)";
	public static String createDaybook = "insert into Daybook values(?,?,?,?,?,?)";
	public static String deposite = "update Daybook set balance = ? where accountNo=?";
	public static String getStatement = "select * from Daybook";
	public static String checkBalance = "select * from Daybook where accountNo=?";
	public static String getAccount = "select balance from Account where accountNo = ?";

}
