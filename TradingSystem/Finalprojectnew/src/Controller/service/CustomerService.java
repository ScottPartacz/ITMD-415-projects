package Controller.service;

import java.util.Date;
import java.util.List;

import Model.Dao.CustomerDao;
import Model.Dao.UserDao;
import Model.DaoImpl.UserOperation;
import Model.DaoImpl.customerOperation;
import Model.entities.Cars;
import Model.entities.Order;

public class CustomerService {
	customerOperation custs=new CustomerDao();
	UserOperation u=new UserDao();
	public List<Cars> viewCarslist(){
	
		List<Cars> carslist=u.viewCarlist();
		
		return carslist;
	}
	public Cars viewcardetail(String carid) {
		
		UserOperation u=new UserDao();
		Cars car=u.Cardetail(carid);
		return car;
	}
	public void createOrder(String orderid, String sellerid, String Customerid, List<Cars> carslist, String status,Date date) {

		custs.createorder( orderid, sellerid,Customerid, carslist, status, date);
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
