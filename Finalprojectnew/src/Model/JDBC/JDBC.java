package Model.JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBC {
	private static final String URL="jdbc:mysql://www.papademas.net:3306/ps";
	private static final String USER="ps";
	private static final String PASSWORD="ps1";
	
	private Connection conn=null;
	
	 {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return conn;
	
 }
}
