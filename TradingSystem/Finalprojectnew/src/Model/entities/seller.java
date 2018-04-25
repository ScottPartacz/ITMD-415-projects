package Model.entities;

import java.util.List;

public class seller extends User{

	private String address;
	private Order order;
	private List<Cars> carlist;
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
	public List<Cars> getCarlist() {
		return carlist;
	}
	public void setcarlist(List<Cars> carlist) {
		this.carlist = carlist;
	}
	
}
