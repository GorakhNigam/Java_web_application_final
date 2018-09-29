package com.virtusa.tms.beans;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	private int serialNo;
	private String employeeName;
	private String emailId;
	private String source;
	private String destination;
	private String travelPurpose;
	private String travelMode;
	private double travelExpense;
	private int duration;
//	private Date dateFrom;
//	private Date dateTo;
	private String status;
	
	public Employee() {
		super();
	}

	
	
	public Employee(String employeeName, String emailId, String source, String destination, String travelPurpose,
			String travelMode, int duration, String status) {
		super();
		this.employeeName = employeeName;
		this.emailId = emailId;
		this.source = source;
		this.destination = destination;
		this.travelPurpose = travelPurpose;
		this.travelMode = travelMode;
		this.travelExpense = travelExpense;
		this.duration = duration;
		this.status = status;
	}

	public Employee(int serialNo, String employeeName, String emailId, String source, String destination, String travelPurpose,
			String travelMode, int duration, String status) {
		super();
		this.employeeName = employeeName;
		this.emailId = emailId;
		this.source = source;
		this.destination = destination;
		this.travelPurpose = travelPurpose;
		this.travelMode = travelMode;
		this.travelExpense = travelExpense;
		this.duration = duration;
		this.status = status;
		this.serialNo = serialNo;
	}
	
	public int getSerialNo() {
		return serialNo;
	}
	
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTravelPurpose() {
		return travelPurpose;
	}

	public void setTravelPurpose(String travelPurpose) {
		this.travelPurpose = travelPurpose;
	}

	public String getTravelMode() {
		return travelMode;
	}

	public void setTravelMode(String travelMode) {
		this.travelMode = travelMode;
	}

	public double getTravelExpense() {
		return travelExpense;
	}

	public void setTravelExpense(double travelExpense) {
		this.travelExpense = travelExpense;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
