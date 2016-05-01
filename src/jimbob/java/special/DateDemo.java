package jimbob.java.special;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) throws ParseException {
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:sss");
		System.out.println(format.format(date));
		
		String strDate="2016-04-30 11:56:01:004";
		System.out.println(format.format(format.parse(strDate)));
		
		Calendar cal=Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH+3));
	}
}
