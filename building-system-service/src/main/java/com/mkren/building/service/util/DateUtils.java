package com.mkren.building.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {

	private DateUtils() {
		throw new AssertionError("Class contains static methods only. You should not instantiate it!");
	}
	
	public static Date parseDate(String strDate){
		
		if(strDate == null || strDate.equals("")){
			return null;
		}
		
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
		
	      Date parsingDate = null;
	      try {
	         parsingDate = ft.parse(strDate); 
	      }catch (ParseException e) { 
	         System.out.println("Нераспаршена с помощью " + ft); 
	      }
	      
		return parsingDate;
	}
	
	public static boolean compareData(java.sql.Date compareData, java.sql.Date dateWith, java.sql.Date dateOn){
		boolean with = false;
		boolean on = false;
		boolean compare = false;
		
		if(dateWith !=null && dateOn !=null){
			// расположим даты для сравнения в правильном хронологич порядке
			if(dateWith.after(dateOn)){
				java.sql.Date date = dateWith;
				dateWith = dateOn;
				dateOn = date;
			}
			
			with = compareData.compareTo(dateWith)!=-1;
			on = compareData.compareTo(dateOn)!=1;
			if(with && on){
				compare = true;
			}
			
		}else if(dateWith !=null && dateOn ==null){
			with = compareData.compareTo(dateWith)!=-1;
			if(with){
				compare = true;
			}
			
		}else if(dateWith ==null && dateOn !=null){
			on = compareData.compareTo(dateOn)!=1;
			if(on){
				compare = true;
			}
		}else{
			compare = true;
		}
		
		return compare;
	}
}
