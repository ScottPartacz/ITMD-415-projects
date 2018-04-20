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
		
	      String sql = "CREATE TABLE hq_customers ( "+
	    		  "Userid varchar(20) not null primary key,"+
	    		  "Username varchar(30),"+
	    		  "Password varchar(30),"+
	    		  "Address varchar(50));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("h_liu_tab1 has been created");
		}
	}
	public void createsellerTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE sellers("+
	    		  "Userid varchar(20) not null primary key,"+
	    		  "Username varchar(30),"+
	    		  "Password varchar(30),"+
	    		  "Address varchar(50));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("h_liu_tab2 has been created");
		}
	}
	public void createsadministratorTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE Administrators (" + 
	      		"Userid varchar(20) not null primary key," + 
	      		"Username varchar(30)," + 
	      		"Password varchar(30));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("h_liu_tab3 has been created");
		}
	}
	public void creategoodsTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE Goods (" + 
	      		"Goodid varchar(20) not null primary key," + 
	      		"Goodname varchar(30)," + 
	      		"Amount int," + 
	      		"Price float,"+
	      		"description varchar(100),"+
	      		"sllerid varchar(20));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("h_liu_tab4 has been created");
		}
	}
	public void createtransactionTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE Transactions(" + 
	      		"Transactionid varchar(20) not null primary key," + 
	      		"Transactiondetails varchar(50)," + 
	      		"Date Date);";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("h_liu_tab5 has been created");
		}
	}
	public void createGoods_SellersTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE GOODS_SELLERS(" + 
	      		"Goodid varchar(20) not null primary key," + 
	      		"Sellerid varchar(20));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("h_liu_tab6 has been created");
		}
	}
	public void createorderTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE Orders(" + 
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
			System.out.println("h_liu_tab7 has been created");
		}
	}
}
