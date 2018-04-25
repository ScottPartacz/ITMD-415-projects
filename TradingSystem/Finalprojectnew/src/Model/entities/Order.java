package Model.entities;

import java.util.Date;
import java.util.List;

public class Order{

	private String orderid;
	private String carid;
	private String customerid;
	private String sellerid;
	private String status;
	private Date date;
	
	public String getcarid() {
		return carid;
	}
	public void setCarid(String carid) {
		this.carid = carid;
	}
	public String getSeller() {
		return sellerid;
	}
	public void setSeller(String sellerid) {
		this.sellerid = sellerid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setUserid(String customerid) {
		this.customerid = customerid;
	}
	public boolean checkcarsAmount(List<Cars> listg){
		return true;
	}
	
	
}
