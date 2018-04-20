package Model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.DaoImpl.UserOperation;
import Model.JDBC.JDBC;
import Model.entities.Goods;
import Model.entities.Order;

public class UserDao implements UserOperation{


	@Override
	public void cancelOrder(String orderid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			String sql="update orders set status='cancel' where orderid="+orderid;
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
	public List<Goods> viewGoodslist() {
		// TODO Auto-generated method stub
		
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		List<Goods> list=new ArrayList<Goods>();
		Statement stat=null;
		ResultSet res=null;
		String sql="select * from goods";
		try {
			stat = conn.createStatement();
		res= stat.executeQuery(sql);
		while(res.next()) {
			Goods g=new Goods();
			g.setGoodsid(res.getString("Goodid"));
			g.setGoodsname(res.getString("Goodname"));
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
			sql+="orders where Customerid="+"'"+userid+"'";
		}else if(role.toLowerCase().equals("seller")){
			sql+="orders where Sellerid="+"'"+userid+"'";
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
			o.setGoodid(res.getString("Goodid"));
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
	public Goods Gooddetail(String goodid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		ResultSet res=null;
		String sql="select * from Goods where Goodid="+"'"+goodid+"'";
		Goods g=new Goods();
		try {
			stat = conn.createStatement();
		res= stat.executeQuery(sql);

		while(res.next()) {
			
			g.setGoodsid(res.getString("Goodid"));
			g.setGoodsname(res.getString("Goodname"));
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
		res= stat.executeQuery("select * from orders where orderid="+orderid);
			while(res.next()) {
			o.setOrderid(res.getString("orderid"));
			o.setSeller(res.getString("sellerid"));
			o.setDate(res.getDate("Date"));
			o.setStatus(res.getString("status"));
			o.setUserid(res.getString("customerid"));
			o.setGoodid(res.getString("Goodid"));
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
