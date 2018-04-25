package Controller.service;

import Model.Dao.AdministratorDao;
import Model.Dao.CustomerDao;
import Model.Dao.SellerDao;
import Model.DaoImpl.AdministratorOperation;
import Model.DaoImpl.customerOperation;
import Model.DaoImpl.sellerOperation;
import Model.entities.Administrator;
import Model.entities.customer;
import Model.entities.seller;

public class LoginService {

	public String SellectUser(String userid, String password, String role) {
		System.out.print(userid+" "+role);
		if(role.equals("customer")) {
			customerOperation c=new CustomerDao();
			customer cust=c.selectCustomer(userid);
			if(password.equals(cust.getPassword())) {
				
				return cust.getUsername();
			}else {
				//System.out.print(cust.getPassword()+" "+cust.getUsername());
				return "worry information";
			}
		}else if(role.equals("seller")) {
			sellerOperation s=new SellerDao();
			seller seller=s.selectSeller(userid);
			if(password.equals(seller.getPassword())) {
				return seller.getUsername();
			}else {
				return "worry information";
			}
		}else {
			AdministratorOperation a=new AdministratorDao();
			Administrator admin=a.selectadministrator(userid);
			if(password.equals(admin.getPassword())) {
				return admin.getUsername();
			}else {
				return "worry information";
			}
		}
	}
	public Boolean checkcustomer(String userid) {
		customerOperation c=new CustomerDao();
		customer cust=c.selectCustomer(userid);
		if(cust!=null) {
			return false;
		}else {
			return true;
		}
	}
	public Boolean checkseller(String userid) {
		sellerOperation s=new SellerDao();
		seller ss=s.selectSeller(userid);
		if(ss!=null) {
			return false;
		}else {
			return true;
		}
	}
}
