package jdbc;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParsing {
	public static Date convertDate(String date) {
		Date sqldate = null;
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		try {
			java.util.Date dt = sdf.parse(date);
			sqldate = new Date(dt.getTime());
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return sqldate;
		
	}
}