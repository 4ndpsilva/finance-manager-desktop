package aps.spreadsheetimporter.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static final String URL;
	private static final String USER;
	private static final String PASSWORD;
	private static final String DATABASE;
	private static Connection connection;
	
	private static Properties properties; 
	
	static {
		
		try {
			properties = new Properties();
			properties.load(new FileInputStream(new File("")));
			
			URL      = "";
			USER     = "";
			PASSWORD = "";
			DATABASE = "";
		}
		catch (Exception e) {
			throw new Exception(e);
		}		
	}
	
	public static Connection getConnection() throws SQLException{
		return connection == null ? DriverManager.getConnection("", properties ) : connection ;
	}
}