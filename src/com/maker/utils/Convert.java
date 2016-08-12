package com.maker.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Convert {
	
	public static String DateConveret(Date date,String pattern){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			return dateFormat.format(date);
	}
		
}
