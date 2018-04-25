package Model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.DaoImpl.UserOperation;
import Model.JDBC.JDBC;
import Model.entities.Cars;
import Model.entities.Order;

public  class UserDao implements UserOperation{


	@Override
	public void cancelOrder(String orderid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			String sql="update orders10 set status='cancel' where orderid="+orderid;
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
	public List<Cars> viewCarlist() {
		// TODO Auto-generated method stub
		
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		List<Cars> list=new ArrayList<Cars>();
		Statement stat=null;
		ResultSet res=null;
		String sql="select * from cars10";
		try {
			stat = conn.createStatement();
		res= stat.executeQuery(sql);
		while(res.next()) {
			Cars g=new Cars();
			g.setCarid(res.getString("carid"));
			g.setmodelname(res.getString("model"));
			g.setAmount(Integer.parseInt(res.getString("amount")));
			g.setPrice(Float.parseFloat(res.getString("price")));
			g.setSellerid(res.getString("sllerid"));
			g.setDescription(res.getString("description"));
			list.add(g);
		}
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return list;
		
	}
	@Override
	public List<Order> vieworderlist(String role, String userid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		List<Order> list=new ArrayList<Order>();
		Statement stat=null;
		ResultSet res=null;
		String sql="select * from ";
		if(role.toLowerCase().equals("customer")) {
			sql+="orders10 where Customerid="+"'"+userid+"'";
		}else if(role.toLowerCase().equals("seller")){
			sql+="orders10 where Sellerid="+"'"+userid+"'";
		}else {
			sql+="orders";
		}
		try {
			stat = conn.createStatement();
		res= stat.executeQuery(sql);
		while(res.next()) {
			Order o=new Order();
			o.setOrderid(res.getString("orderid"));
			o.setSeller(res.getString("sellerid"));
			o.setDate(res.getDate("Date"));
			o.setStatus(res.getString("status"));
			o.setUserid(res.getString("customerid"));
			o.setCarid(res.getString("Carid"));
			list.add(o);
		}
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return list;
	}

	@Override
	public Cars Cardetail(String carid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		ResultSet res=null;
		String sql="select * from cars10 where carid="+"'"+carid+"'";
		Cars g=new Cars();
		try {
			stat = conn.createStatement();
		res= stat.executeQuery(sql);

		while(res.next()) {
			
			g.setCarid(res.getString("carid"));
			g.setmodelname(res.getString("model"));
			g.setAmount(Integer.parseInt(res.getString("amount")));
			g.setPrice(Float.parseFloat(res.getString("price")));
			g.setSellerid(res.getString("sllerid"));
			g.setDescription(res.getString("description"));
		}
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return g;
	}
	@Override
	public Order vieworderdetail(String orderid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Order o=new Order();
		Connection conn= c.getConnection();
		Statement stat=null;
		ResultSet res=null;
		try {
			stat = conn.createStatement();
		res= stat.executeQuery("select * from orders10 where orderid="+orderid);
			while(res.next()) {
			o.setOrderid(res.getString("orderid"));
			o.setSeller(res.getString("sellerid"));
			o.setDate(res.getDate("Date"));
			o.setStatus(res.getString("status"));
			o.setUserid(res.getString("customerid"));
			o.setCarid(res.getString("carid"));
			}
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
			
	}
}
