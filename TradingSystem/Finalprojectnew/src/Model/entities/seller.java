package Model.entities;

import java.util.List;

public class seller extends User{

	private String address;
	private Order order;
	private List<Goods> goodlist;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Goods> getGoodlist() {
		return goodlist;
	}
	public void setGoodlist(List<Goods> goodlist) {
		this.goodlist = goodlist;
	}
	
}
