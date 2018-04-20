package Model.DaoImpl;

import java.util.List;

import Model.entities.Goods;
import Model.entities.Order;

public interface UserOperation {

	
	public List<Goods> viewGoodslist();
	public void cancelOrder(String orderid);
	public Order vieworderdetail(String orderid);
	public List<Order> vieworderlist(String role, String userid);
	public Goods Gooddetail(String goodid);
}
