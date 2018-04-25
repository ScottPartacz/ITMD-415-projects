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
	public void createCar(String carid, String model, String amount, String price,String sellerid,String description) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		int am=Integer.parseInt(amount);
		float p=Float.parseFloat(price);
			try {
				stat = conn.createStatement();
	      String sql = "INSERT INTO cars10 (carid,model,amount,price,sllerid,description) values("+"'"+carid+"',"+
		"'"+model+"',"+"'"+am+"',"+"'"+p+"',"+"'"+sellerid+"'"+","+"'"+description+"'"+")";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void updateCar(String carid, String model, String amount, String price,String description) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			String sql="update cars10 set model= "+"'"+model+"'"+", amount="+"'"+amount+"'"+", price="+price+", description="+"'"+description+"'"+" where carid="+"'"+carid+"'";
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
	public void deletecar(String carid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			String sql="delete from cars10 where carid="+"'"+carid+"'";
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
	      String sql = "INSERT INTO sellers10 (userid,username,password,address) values("+"'"+userid+"',"+
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
	      String sql = "update sellers10 set username="+"'"+username+"'"+", password="+"'"+password+"'"+", address="+"'"+address+"'"
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
		String sql="select * from sellers10 where userid="+"'"+sellerid+"'";
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
	public List<Cars> viewCars(String sellerid) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		ResultSet res=null;
		List<Cars> listcars=new ArrayList<Cars>();
		try {
			String sql="select * from cars10 where sllerid="+"'"+sellerid+"'";
			stat = conn.createStatement();
			res=stat.executeQuery(sql);
			while(res.next()) {
				Cars g=new Cars();
				g.setCarid(res.getString("carid"));
				g.setmodelname(res.getString("model"));
				g.setAmount(res.getInt("Amount"));
				g.setPrice(res.getFloat("Price"));
				g.setSellerid(res.getString("sllerid"));
				g.setDescription(res.getString("description"));
				listcars.add(g);
			}
		res.close();
		stat.close();
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listcars;
	}
	

}
