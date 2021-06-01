package com.DollarDays.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;//object
	
	public ReadConfig() {    //constructor
		
		try {
	File src= new File("./Config/config.properties");	
	
	FileInputStream fis = new FileInputStream(src);	
	
	pro=new Properties();
	
		pro.load(fis);
	}
		catch(Exception e) {
			
		System.out.println("Exception is" + e.getMessage());
		}
	}
 
	
	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
		
	}
	
	public String getusername() {
		String username= pro.getProperty("username");
		return username;
	}
	
	public String getpassword() {
		String password=pro.getProperty("password");
		return password;
	}
	
	

	
}

	

	



