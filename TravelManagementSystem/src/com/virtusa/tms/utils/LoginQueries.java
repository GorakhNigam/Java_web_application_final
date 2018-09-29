package com.virtusa.tms.utils;

public class LoginQueries {
	public static String pass = "select password from EmployeeLogin where username=?";
	public static String allEmp = "select * from TravelInfo where emailId=?";
}
