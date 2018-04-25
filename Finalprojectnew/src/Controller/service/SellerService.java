package Controller.service;

import java.util.List;

import Model.Dao.SellerDao;
import Model.DaoImpl.sellerOperation;
import Model.entities.Cars;
import Model.entities.seller;

public class SellerService {
	sellerOperation s=new SellerDao();
	public seller selectSeller(String sellerid) {
		
		seller seller=s.selectSeller(sellerid);
		return seller;
	}
	public List<Cars> Carslist(String sellerid) {
		
		List<Cars> carslist=s.viewCars(sellerid);
		return carslist;
	}
	public void createcar(Cars g) {
		s.createCar(g.getCarid(), g.getModel(), String.valueOf(g.getAmount()), String.valueOf(g.getPrice()), g.getSellerid(),g.getDescription());
	}
	public void deletecar(String carid) {
		s.deletecar(carid);
	}
	public void updatecar(Cars g) {
		
		s.updateCar(g.getCarid(), g.getModel(), String.valueOf(g.getAmount()), String.valueOf(g.getPrice()), g.getDescription());
	}

}
