package com.maker.utils;

import java.util.UUID;

public class FileUploadUtil {
	public static synchronized String generateFileName(){
		return UUID.randomUUID().toString();
	}

}
