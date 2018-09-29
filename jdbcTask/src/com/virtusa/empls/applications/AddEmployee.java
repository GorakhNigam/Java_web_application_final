package com.virtusa.empls.applications;

import com.virtusa.empls.beans.Employee;
import com.virtusa.empls.dao.EmployeeDao;

public class AddEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = new Employee(121, "virtusa","trainer", 55000,"04-09-2018");
		EmployeeDao dao = new EmployeeDao();
		int rows = dao.addEmployee(emp);
		if(rows>0)
			System.out.println("inserted");
		else
			System.out.println("not inserted");
	}

}
