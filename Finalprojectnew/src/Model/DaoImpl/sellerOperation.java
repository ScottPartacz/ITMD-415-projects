package Model.DaoImpl;

import Model.entities.seller;

import java.util.List;
import Model.entities.Cars;
public interface sellerOperation {


	public void createSller(String userid, String username, String password, String address);
	public void deletecar(String carid);
	public void updateseller(String userid, String username, String password, String address);
	public seller selectSeller(String sllerid);
	public List<Cars> viewCars(String sellerid);
	void createCar(String carid, String model, String amount, String price, String sellerid, String description);
	void updateCar(String carid, String model, String amount, String price, String description);
	
}
