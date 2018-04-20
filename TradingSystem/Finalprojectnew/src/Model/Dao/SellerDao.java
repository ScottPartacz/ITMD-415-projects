package Model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.DaoImpl.sellerOperation;
import Model.JDBC.JDBC;
import Model.entities.*;

public class SellerDao implements sellerOperation{

	@Override
	public void createGood(String goodid, String goodname, String amount, String price,String sellerid,String description) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		int am=Integer.parseInt(amount);
		float p=Float.parseFloat(price);
			try {
				stat = conn.createStatement();
	      String sql = "INSERT INTO goods (goodid,goodname,amount,price,sllerid,description) values("+"'"+goodid+"',"+
		"'"+goodname+"',"+"'"+am+"',"+"'"+p+"',"+"'"+sellerid+"'"+","+"'"+description+"'"+")";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void updateGood(String goodid, String goodname, String amount, String price,String description) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			String sql="update goods set goodname= "+"'"+goodname+"'"+", amount="+"'"+amount+"'"+", price="+price+", description="+"'"+description+"'"+" where Goodid="+"'"+goodid+"'";
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
	public void deleteGood(String goodid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			String sql="delete from goods where goodid="+"'"+goodid+"'";
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
	public void createSller(String userid, String username, String password, String address) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
			try {
				stat = conn.createStatement();
	      String sql = "INSERT INTO sellers (userid,username,password,address) values("+"'"+userid+"',"+
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
	public void updateseller(String userid, String username, String password, String address) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		
			try {
				stat = conn.createStatement();
	      String sql = "update sellers set username="+"'"+username+"'"+", password="+"'"+password+"'"+", address="+"'"+address+"'"
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
	public seller selectSeller(String sellerid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		ResultSet res=null;
		String sql="select * from sellers where userid="+"'"+sellerid+"'";
		seller s=new seller();
		try {
			stat = conn.createStatement();
		    res= stat.executeQuery(sql);

		while(res.next()) {
			
			s.setUserid(res.getString("userid"));
			s.setPassword(res.getString("password"));
			s.setUsername(res.getString("username"));
			s.setAddress(res.getString("address"));
		}
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return s;
	}

	@Override
	public List<Goods> viewGoods(String sellerid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		ResultSet res=null;
		List<Goods> listgoods=new ArrayList<Goods>();
		try {
			String sql="select * from goods where sllerid="+"'"+sellerid+"'";
			stat = conn.createStatement();
			res=stat.executeQuery(sql);
			while(res.next()) {
				Goods g=new Goods();
				g.setGoodsid(res.getString("Goodid"));
				g.setGoodsname(res.getString("Goodname"));
				g.setAmount(res.getInt("Amount"));
				g.setPrice(res.getFloat("Price"));
				g.setSellerid(res.getString("sllerid"));
				g.setDescription(res.getString("description"));
				listgoods.add(g);
			}
		res.close();
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listgoods;
	}
	

}
