package Controller.service;


import Model.Dao.CustomerDao;
import Model.Dao.SellerDao;
import Model.Dao.UserDao;
import Model.DaoImpl.UserOperation;
import Model.DaoImpl.customerOperation;
import Model.DaoImpl.sellerOperation;
import Model.entities.Goods;
import Model.entities.Order;

public class Userservice {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		UserDao a=new UserDao();
//		List<Order> o=a.vieworderlist("customer", "222");
//		List<Goods> g=a.viewGoodslist();
//		for(int i=0;i<o.size()&&i<g.size();i++) {
//			System.out.println(o.get(i).getOrderid()+" "+o.get(i).getGoodid());
//			System.out.println(g.get(i).getAmount()+g.get(i).getGoodsname());
//		}
//		Goods aa=a.Gooddetail("123");
//		//System.out.println(aa.getAmount()+aa.getGoodsid());
//		//CreateDatabase a=new CreateDatabase();
//		//a.creategoodsTable();
//		
//	}
	public Order viewOrderDetails(String orderid) {
		UserOperation u=new UserDao();
		Order o=u.vieworderdetail(orderid);
		return o;
	}
	public Goods goodDetail(String goodid) {
		UserOperation u=new UserDao();
		Goods g=u.Gooddetail(goodid);
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
