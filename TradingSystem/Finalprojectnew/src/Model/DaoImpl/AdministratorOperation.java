package Model.DaoImpl;

import java.util.List;

import Model.entities.*;

public interface AdministratorOperation {

	public void viewTransactionList();
	public void deleteTransactionList();
	public void updateTransaction();
	public void viewTransactiondetail();
	public void createTransaction();
	public void deleteCustomer(String customerid);
	public void deleteSeller(String sellerid);
	public Administrator selectadministrator(String adminid);
	public List<customer> viewCustomers();
	public List<seller> viewSellers();
	void deleteorder(String orderid);
}
