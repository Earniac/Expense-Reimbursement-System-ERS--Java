package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomConnectionFactory {

	public static String url = "jdbc:postgresql://eacey.c0zahdhkchtn.us-east-2.rds.amazonaws.com/Project1";
	public static String username= "eacey";
	public static String password="QuickstarT98";
	
//	public static String url = "jdbc:postgresql://datachan.c4wt8faaxlgp.us-east-2.rds.amazonaws.com/superhuman";
//	public static String username= "datachan";
//	public static String password="p4ssw0rd";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
}
