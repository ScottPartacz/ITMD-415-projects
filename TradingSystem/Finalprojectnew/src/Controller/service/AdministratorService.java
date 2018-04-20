package Controller.service;

import java.util.List;

import Model.Dao.AdministratorDao;
import Model.Dao.CustomerDao;
import Model.Dao.SellerDao;
import Model.DaoImpl.AdministratorOperation;
import Model.DaoImpl.customerOperation;
import Model.DaoImpl.sellerOperation;
import Model.entities.customer;
import Model.entities.seller;

public class AdministratorService {
	AdministratorOperation a=new AdministratorDao();
	public List<customer> ViewCustomers(){
		
		List<customer>clist=a.viewCustomers();
		return clist;
	}
	public List<seller> ViewSellers(){
		List<seller>slist=a.viewSellers();
		return slist;
	}
	public void deletecustomer(String customerid) {
		a.deleteCustomer(customerid);
	}
	public void deleteseller(String sellerid) {
		a.deleteSeller(sellerid);
	}
	public void deleteorder(String orderid) {
		a.deleteorder(orderid);
	}
	public void updateuser(String role, String userid,String username, String password, String address) {
		if(role.equals("customer")) {
			customerOperation custO=new CustomerDao();
			custO.updatecustomer(userid, username, password, address);
		}else if(role.equals("seller")) {
			sellerOperation sellerO=new SellerDao();
			sellerO.updateseller(userid, username, password, address);
		}
	}

}
