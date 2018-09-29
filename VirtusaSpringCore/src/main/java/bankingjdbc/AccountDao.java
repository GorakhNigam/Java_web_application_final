package bankingjdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.ResultSet;

import jdbc.DateParsing;
import jdbc.EmplDBQueries;
import jdbc.Employee;
import jdbc.EmployeePSS;

@Repository
public class AccountDao {
	@Autowired
	Account acc;
	@Autowired
	AccountPSS pss;
	@Autowired
	public AccountDao(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
	}
	public void createAccount() {
		//String sql = "insert into Account values(?,?,?,?)";
		Object args[] = {acc.getAccontNo(), acc.getCustomerName(),acc.getBalance(),DateParsing.convertDate(acc.getDateOpened())};
		getJdbcTemplate().update(BankingQueries.createAccount,pss);
	}
	public double deposite() {
		Object args[] = {acc.getAccontNo()};
		java.sql.ResultSet rs = getJdbcTemplate().update(BankingQueries.getAccount,pss);
		rs.next();
		double bal = rs.getDouble("balance");
		Object args[] = {acc.getBalance()+bal,acc.getAccontNo()};
		int row = getJdbcTemplate().update(BankingQueries.deposite,pss);
		return row;
	}
	public int withdraw() {
		Object args[] = {acc.getAccontNo()};
		java.sql.ResultSet rs = getJdbcTemplate().update(BankingQueries.getAccount,pss);
		rs.next();
		double bal = rs.getDouble("balance");
		Object args[] = {acc.getBalance()+bal,acc.getAccontNo()};
		int row = getJdbcTemplate().update(BankingQueries.deposite,pss);
		return row;
	}
	public void checkBalance() {
		Object args[] = {acc.getAccontNo()};
		getJdbcTemplate().update(BankingQueries.checkBalance,pss);
	}
}
