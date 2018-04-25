package Controller.service;


import Model.Dao.CustomerDao;
import Model.Dao.SellerDao;
import Model.Dao.UserDao;
import Model.DaoImpl.UserOperation;
import Model.DaoImpl.customerOperation;
import Model.DaoImpl.sellerOperation;
import Model.entities.Cars;
import Model.entities.Order;

public class Userservice {

	public Order viewOrderDetails(String orderid) {
		UserOperation u=new UserDao();
		Order o=u.vieworderdetail(orderid);
		return o;
	}
	public Cars carDetail(String carid) {
		UserOperation u=new UserDao();
		Cars g=u.Cardetail(carid);
		return g;
	}
	public boolean createuser(String role, String userid, String username,String address, String password) {
		if(role.equals("customer")) {
			customerOperation cust=new CustomerDao();
			
			if(cust.selectCustomer(userid).getPassword()==null) {
			cust.createCustomer(userid, username, password, address);
			return true;
			}else {
				return false;
			}
		}else {
			sellerOperation sel=new SellerDao();
			if(sel.selectSeller(userid).getPassword()==null) {		    
		    sel.createSller(userid, username, password, address);
		    return true;
		    }else {
		    	return false;
		    }
		}
	}

}
