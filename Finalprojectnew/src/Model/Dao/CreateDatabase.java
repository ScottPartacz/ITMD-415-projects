package Model.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Model.JDBC.JDBC;


public class CreateDatabase {
	public void createcustomerTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE hq_customers10 ( "+
	    		  "Userid varchar(20) not null primary key,"+
	    		  "Username varchar(30),"+
	    		  "Password varchar(30),"+
	    		  "Address varchar(50));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	public void createsellerTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE sellers10("+
	    		  "Userid varchar(20) not null primary key,"+
	    		  "Username varchar(30),"+
	    		  "Password varchar(30),"+
	    		  "Address varchar(50));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	public void createsadministratorTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE Administrators10 (" + 
	      		"Userid varchar(20) not null primary key," + 
	      		"Username varchar(30)," + 
	      		"Password varchar(30));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	public void creategoodsTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE cars10 (" + 
	      		"carid varchar(20) not null primary key," + 
	      		"model varchar(30)," + 
	      		"Amount int," + 
	      		"Price float,"+
	      		"description varchar(100),"+
	      		"sllerid varchar(20));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	public void createtransactionTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE Transactions10(" + 
	      		"Transactionid varchar(20) not null primary key," + 
	      		"Transactiondetails varchar(50)," + 
	      		"Date Date);";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	public void createGoods_SellersTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE car_SELLERS(" + 
	      		"carid varchar(20) not null primary key," + 
	      		"Sellerid varchar(20));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	public void createorderTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE Orders10(" + 
	      		"Orderid varchar(20) not null primary key," + 
	      		"Customerid varchar(20)," + 
	      		"Sellerid varchar(20)," + 
	      		"Goodid varchar(20)," + 
	      		"Status varchar(20)," + 
	      		"Date Date);";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
}
