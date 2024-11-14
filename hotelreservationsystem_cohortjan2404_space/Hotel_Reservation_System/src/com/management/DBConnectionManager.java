package com.management;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionManager {
	private static Connection conn=null;
	private static Properties props=new Properties();
	
	public static Connection getConnection() 
	{
		try
		{
			FileInputStream fis=null;
			fis=new FileInputStream("database.Properties");
			
			props.load(fis);
			Class.forName(props.getProperty("DriverClass"));
			conn=DriverManager.getConnection(props.getProperty("url"),props.getProperty("username"),props.getProperty("password"));

		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
