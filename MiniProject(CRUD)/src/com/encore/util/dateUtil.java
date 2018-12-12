package com.encore.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class dateUtil {
	public static Date stringToDate(String date) {
		//// String ->java.util.Date -> java.sql.Date
		Date sqlDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date utilDate = sdf.parse(date);
			sqlDate = new Date(utilDate.getTime());
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return sqlDate;
	}
}
