package bankingjdbc;

import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import jdbc.Employee;

@Component
public class BankingPSS implements PreparedStatementSetter{
	@Autowired
	Account acc;
	
	@Override
	public void setValues(PreparedStatement pst) throws SQLException {
		// TODO Auto-generated method stub
//		pst.setInt(1,emp.getEmpcode());
//		pst.setString(2, emp.getEmpname());
//		pst.setString(3,emp.getJob());
//		pst.setDouble(4, emp.getSalary());
//		pst.setDate(5, DateParsing.convertDate(emp.getDoj()));
		pst.setDouble(1, emp.getSalary());
		pst.setInt(2,emp.getEmpcode());
	}

}
