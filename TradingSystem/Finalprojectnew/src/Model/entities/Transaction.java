package Model.entities;

import java.util.Date;
import java.util.List;

public class Transaction{

	private String userid;
	private List<Order>list;
	private String transactionid;
	private String transactiondetail;
	private Date date;
	
	public String getTransactiondetail() {
		return transactiondetail;
	}
	public void setTransactiondetail(String transactiondetail) {
		this.transactiondetail = transactiondetail;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public List<Order> getList() {
		return list;
	}
	public void setList(List<Order> list) {
		this.list = list;
	}
	
	
}
