package Model.DaoImpl;

import java.util.List;

import Model.entities.Cars;
import Model.entities.Order;

public interface UserOperation {

	
	public List<Cars> viewCarlist();
	public void cancelOrder(String orderid);
	public Order vieworderdetail(String orderid);
	public List<Order> vieworderlist(String role, String userid);
	public Cars Cardetail(String goodid);
}
