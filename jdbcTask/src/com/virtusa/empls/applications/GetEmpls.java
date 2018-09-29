package com.virtusa.empls.applications;

import java.util.List;

import com.virtusa.empls.beans.Employee;
import com.virtusa.empls.dao.EmployeeDao;

public class GetEmpls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDao dao = new EmployeeDao();
		List<Employee> empls = dao.getAllEmpls();
		for(Employee e : empls) 
			System.out.println(e.getEmpcode()+e.getEmpname());
		dao.getUpdate(60000, 121);
		dao.delEmployee(121);
//		List<Employee> emp1 = dao.getUpdate(1.25*55000, 121);
//		for(Employee e : empls) 
//			System.out.println("salary update"+e.getEmpcode()+" "+e.getSalary());
		Employee emp = dao.getEmpl(121);
		if (emp == null)
			System.out.println("employee not exists");
		else
			System.out.println(emp.getEmpcode()+emp.getEmpname());
	}

}
