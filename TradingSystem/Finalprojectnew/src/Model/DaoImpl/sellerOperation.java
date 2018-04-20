package Model.DaoImpl;

import Model.entities.seller;

import java.util.List;

import Model.entities.Goods;
public interface sellerOperation {


	public void createSller(String userid, String username, String password, String address);
	public void deleteGood(String goodid);
	public void updateseller(String userid, String username, String password, String address);
	public seller selectSeller(String sllerid);
	public List<Goods> viewGoods(String sellerid);
	void createGood(String goodid, String goodname, String amount, String price, String sellerid, String description);
	void updateGood(String goodid, String goodname, String amount, String price, String description);
	
}
