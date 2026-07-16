package com.aspir.usermanagement.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.aspir.usermanagement.expcetion.CustomeApplicationException;

public class DateUtil {

	private DateUtil() {

		// prevent instanstion
	}

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static LocalDate toLocalDate(String date) {
	
		if(date == null || date.trim().isEmpty()) {
			return null;
		}
		
		 try {
			return LocalDate.parse(date,DATE_TIME_FORMATTER);
		 } catch (DateTimeException dtpe) {
			 throw new CustomeApplicationException("Invalid date format and date format should be dd/MM/yyyy");
		 }
		 
	}
		 public static String toString(LocalDate date){
			 
			 if(date == null) {
				 return null;
			 
		 }
			 return date.format(DATE_TIME_FORMATTER);
		 }
}
