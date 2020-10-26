package application;


import java.sql.Connection;

import java.sql.DriverManager;

public class DBConnection 
{
	private Connection con;
	
	public Connection getConn()
	{
		con = null;
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mosipDB", "root", "");
			System.out.println(con);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
		return con;
	}
}
