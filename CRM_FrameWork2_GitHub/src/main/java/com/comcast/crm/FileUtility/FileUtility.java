package com.comcast.crm.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream("./Utility_Files/commondata.properties");
		Properties p= new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		
		return value;
		
	}
	
	

}
