package com.virtusa.banking.util;

	import java.util.Date;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;

	public class DateParsing {
		public static /*Date*/String convertDate(Date date) {
			Date sqldate = null;
			String currentTime = "";
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			try {
				 currentTime = sdf.format(date);
				//java.util.Date dt = sdf.parse(date);
				//sqldate = new Date(dt.getTime());
			}catch(Exception e) {
				e.printStackTrace();
			}
			return currentTime;
			//return sqldate;
			
		}
	}

