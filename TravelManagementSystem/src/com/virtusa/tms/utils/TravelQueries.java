package com.virtusa.tms.utils;

public class TravelQueries {
	public static String addempl = "insert into TravelInfo values(?,?,?,?,?,?,?,?,?,?)";
	public static String getAllEmpls = "select * from TravelInfo where emailId=?";
	public static String everyEmpls = "select * from TravelInfo";
	public static String updateAll = "update TravelInfo set employeeName=?,  source=?, destination=? travelPurpose=?, travelMode=?,duration=? where emailId=?";
	public static String updateStatus = "update TravelInfo set status = ? where serialNo=?";
	public static String updateExpense = "update TravelInfo set travelExpense = ? where serialNo=?";
}
