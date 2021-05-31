package aps.financemanagerdesktop.dao;

import java.io.IOException;
import java.io.InputStream;
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
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream stream = loader.getResourceAsStream("database.properties");
			properties = new Properties();
			properties.load(stream);
			URL = properties.getProperty("url");
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static Connection getConnection() throws SQLException{
		return connection == null || connection.isClosed() ? connection = DriverManager.getConnection(URL, properties) : connection;
	}
}