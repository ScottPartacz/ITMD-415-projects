package Model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.DaoImpl.AdministratorOperation;
import Model.JDBC.JDBC;
import Model.entities.Administrator;
import Model.entities.customer;
import Model.entities.seller;

public class AdministratorDao implements AdministratorOperation{



	@Override
	public void deleteCustomer(String customerid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			String sql="delete from hq_customers where Userid="+"'"+customerid+"'";
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteSeller(String sellerid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			String sql="delete from sellers where Userid="+"'"+sellerid+"'";
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteorder(String orderid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			String sql="delete from orders where orderid="+"'"+orderid+"'";
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void viewTransactionList() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void deleteTransactionList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewTransactiondetail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTransaction() {
		
	}

	@Override
	public Administrator selectadministrator(String userid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		ResultSet res=null;
		String sql="select * from administrators where userid="+" '"+userid+"' ";
		Administrator a=new Administrator();
		try {
			stat = conn.createStatement();
		    res= stat.executeQuery(sql);

		while(res.next()) {
			
			a.setUserid(res.getString("userid"));
			a.setPassword(res.getString("password"));
			a.setUsername(res.getString("username"));
			
		}
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return a;
	}

	@Override
	public List<customer> viewCustomers() {
		// TODO Auto-generated method stub
		
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		ResultSet res=null;
		String sql="select * from hq_customers";
		List<customer> clist=new ArrayList<customer>();
		try {
			stat = conn.createStatement();
		    res= stat.executeQuery(sql);

		while(res.next()) {
			customer a=new customer();
			a.setUserid(res.getString("userid"));
			a.setPassword(res.getString("password"));
			a.setUsername(res.getString("username"));
			a.setAddress(res.getString("address"));
			clist.add(a);
			
		}
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return clist;
	}

	@Override
	public List<seller> viewSellers() {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		ResultSet res=null;
		String sql="select * from sellers";
		List<seller> slist=new ArrayList<seller>();
		try {
			stat = conn.createStatement();
		    res= stat.executeQuery(sql);

		while(res.next()) {
			seller a=new seller();
			a.setUserid(res.getString("userid"));
			a.setPassword(res.getString("password"));
			a.setUsername(res.getString("username"));
			a.setAddress(res.getString("address"));
			slist.add(a);
			
		}
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return slist;
	}

	
}
