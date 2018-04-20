package Model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Model.DaoImpl.customerOperation;
import Model.JDBC.JDBC;
import Model.entities.Goods;
import Model.entities.customer;

public class CustomerDao implements customerOperation{

	@Override
	public void createorder(String orderid, String Customerid, String sellerid, List<Goods> goodslist, String status,Date date) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
			try {
				stat = conn.createStatement();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String d = sdf.format(date);
			String goodid="";
		for(int i=0;i<goodslist.size();i++) {
			Goods g=(Goods) goodslist.get(i);
			String g1=g.getGoodsid();
			goodid+=g1+" ";
		}
	      String sql = "INSERT INTO Orders (Orderid,Sellerid,Customerid,Goodid,Status,Date) values("+"'"+orderid+"',"+
		"'"+Customerid+"',"+"'"+sellerid+"',"+"'"+goodid+"',"+"'"+status+"',"+"'"+d+"'"+")";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


	@Override
	public void makePayment(String orderid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			String sql="update orders set status='paid' where orderid="+orderid;
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
	public void updateorder(String orderid, String Customerid, String sellerid, List<Goods> goodslist, String status,Date date) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = sdf.format(date);
		String goodid="";
		for(int i=0;i<goodslist.size();i++) {
			goodid+=goodslist.get(i).getGoodsid()+" ";
		}
		
		try {
			String sql="update orders set Customerid= "+"'"+Customerid+"'"+", sellerid="+"'"+sellerid+"'"+", date="+"'"+d+"'"+", goodid="+"'"+goodid+"'"+" where orderid="+"'"+orderid+"'";
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
	public void createCustomer(String userid, String username, String password, String address) {
		// TODO Auto-generated method stub
		
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		
			try {
				stat = conn.createStatement();
	      String sql = "INSERT INTO hq_customers (userid,username,password,address) values("+"'"+userid+"',"+
		"'"+username+"',"+"'"+password+"',"+"'"+address+"'"+")";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void updatecustomer(String userid, String username, String password, String address) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		
			try {
				stat = conn.createStatement();
	      String sql = "update hq_customers set username="+"'"+username+"'"+", password="+"'"+password+"'"+", address="+"'"+address+"'"
	    		  +" where userid="+"'"+userid+"'";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


	@Override
	public customer selectCustomer(String userid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		ResultSet res=null;
		String sql="select * from hq_customers where userid="+"'"+userid+"'";
		customer cust=new customer();
		try {
			stat = conn.createStatement();
		    res= stat.executeQuery(sql);

		while(res.next()) {
			
			cust.setUserid(res.getString("userid"));
			cust.setPassword(res.getString("password"));
			cust.setUsername(res.getString("username"));
			cust.setAddress(res.getString("address"));
		}
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(cust);
	return cust;
	}



}
