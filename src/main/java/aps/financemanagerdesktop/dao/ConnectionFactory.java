package aps.financemanagerdesktop.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static String URL;
	private static Connection connection;
	
	private static Properties properties; 
	
	static {
		try {
			properties = new Properties();
			properties.load(new FileInputStream(new File("database.properties")));
			
			URL = properties.getProperty("url");
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static Connection getConnection() throws SQLException{
		return connection == null ? connection = DriverManager.getConnection(URL, properties) : connection;
	}
}