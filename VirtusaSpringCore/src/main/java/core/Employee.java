package core;

public class Employee {
	private int empcode;
	private String empname;
	private double salary;
	private Address address;
	public Employee(int empcode, String empname, double salary) {
		super();
		this.empcode = empcode;
		this.empname = empname;
		this.salary = salary;
	}
	public Employee() {
		super();
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
