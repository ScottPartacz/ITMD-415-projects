package Model.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Model.JDBC.JDBC;

public class create1 {
	public void createSller(String userid, String username, String password, String address) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
			try {
				stat = conn.createStatement();
	      String sql = "INSERT INTO administrators (userid,username,password) values("+"'"+userid+"',"+
		"'"+username+"',"+"'"+password+"'"+")";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//      CreateDatabase a=new CreateDatabase();
//      a.createcustomerTable();
//      a.createGoods_SellersTable();
//      a.creategoodsTable();
//      a.createorderTable();
//      a.createsadministratorTable();
//      a.createsellerTable();
//      a.createtransactionTable();
     create1 aa=new create1();
      aa.createSller("16873", "admin", "qwer123", "123");
	}

}
