package com.spring.jpa.h2.utils;

import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class Constants {

	public static final String DATETIME_FORMAT = "dd-MM-yyyy HH:mm";
	public static LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));	
	
	
}
