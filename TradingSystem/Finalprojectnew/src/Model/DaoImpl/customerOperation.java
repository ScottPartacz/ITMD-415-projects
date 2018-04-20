package Model.DaoImpl;

import java.util.Date;
import java.util.List;

import Model.entities.Goods;
import Model.entities.customer;

public interface customerOperation {

	
	public void createorder(String orderid, String Customerid, String sellerid, List<Goods> goodslist, String status,Date date);
	public void makePayment(String orderid);
	public void createCustomer(String userid, String username, String password, String address);
	public void updateorder(String orderid, String Customerid, String sellerid, List<Goods> goodslist, String status,
			Date date);
	public void updatecustomer(String userid, String username, String password, String address);
	public customer selectCustomer(String userid);
}
