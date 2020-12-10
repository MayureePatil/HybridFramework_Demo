package com.visionIt.orangehrm.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	public Properties prop;
	public ConfigDataProvider() throws IOException
	{
		File fs=new File("./Config/config.properties");
		FileInputStream fis = new FileInputStream(fs);
		prop=new Properties();
		prop.load(fis);
	
	}
	
	public String getKeyValue(String searchkey)
	{
		return prop.getProperty(searchkey);
	}
	public String getUsername()
	{
		return prop.getProperty("username");
	}
	public String getUserPassword()
	{
		return prop.getProperty("password");
	}
	
	public String getUrl()
	{
		return prop.getProperty("url");
	}
}
