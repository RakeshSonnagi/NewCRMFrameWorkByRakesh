package com.comcast.crm.JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	
	public int getRandomNumber() 
	{
		Random r=new Random();
		int randomNum=r.nextInt(100);
		return randomNum;
	}
	public String getpresentDate() 
	{
		Date d= new Date();
		SimpleDateFormat sim =new SimpleDateFormat("yyyy-MM-dd");
		String presentDate = sim.format(d);
		return presentDate;
	}
	public String getFutureDate(int a) {
		Date d=new Date(); 
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		sim.format(d);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, a);
		String futureDate = sim.format(cal.getTime());
		return futureDate;
	} 
}
