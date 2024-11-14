package com.util;
import com.model.Booking;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ApplicationUtil {
	
	public static int convertInt1(String num)
	{
		return Integer.parseInt(num);
	}
	public static long convertLong(String num)
	{
		return Long.parseLong(num);
	}
	public static java.util.Date convertStringToUtilDate(String date)
	{
		String pattern="dd/MM/yyyy";
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		java.util.Date d=null; 
		try
		{
		d=sdf.parse(date);
		}
		catch(ParseException e)
		{
		e.printStackTrace();
		
		}
		return d;
	}
	
	public static java.sql.Date convertUtilToSqlDate(java.util.Date utDate){
		java.sql.Date sqlDate= new java.sql.Date(utDate.getTime());
		return sqlDate;
	}
	
	public List<String> convertList(String[] array)
	{
		List<String> list=new ArrayList<String>();
		for(String a:array)
		{
			list.add(a);
		}
		return list;
	}
	
	
	
	

	
	

}


