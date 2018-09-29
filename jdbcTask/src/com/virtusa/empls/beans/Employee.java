package com.virtusa.empls.beans;

public class Employee {
	private int empcode;
	private String empname;
	private String job;
	private double salary;
	private String doj;
	
	public Employee() {
	}

	public Employee(int empcode, String empname, String job, double salary, String doj) {
		this.empcode = empcode;
		this.empname = empname;
		this.job = job;
		this.salary = salary;
		this.doj = doj;
	}

	public int getEmpcode() {
		return empcode;
	}

	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}
	
	
}
