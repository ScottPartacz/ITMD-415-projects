package Controller.service;

import java.util.Date;
import java.util.List;

import Model.Dao.CustomerDao;
import Model.Dao.UserDao;
import Model.DaoImpl.UserOperation;
import Model.DaoImpl.customerOperation;
import Model.entities.Goods;
import Model.entities.Order;

public class CustomerService {
	customerOperation custs=new CustomerDao();
	UserOperation u=new UserDao();
	public List<Goods> viewGoodslist(){
	
		List<Goods> goodslist=u.viewGoodslist();
		
		return goodslist;
	}
	public Goods viewGooddetail(String goodid) {
		
		UserOperation u=new UserDao();
		Goods good=u.Gooddetail(goodid);
		return good;
	}
	public void createOrder(String orderid, String sellerid, String Customerid, List<Goods> goodslist, String status,Date date) {

		custs.createorder( orderid, sellerid,Customerid, goodslist, status, date);
	}
	public List<Order> ViewOrders(String role,String userid){
		List<Order> orderlist=u.vieworderlist(role, userid);
		return orderlist;
	}
	public void payforOrder(String orderid) {
		custs.makePayment(orderid);
		
	}
	public void cancelOrder(String orderid) {
		u.cancelOrder(orderid);
	}

	
}
