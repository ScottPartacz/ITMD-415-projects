package Controller.service;

import java.util.List;

import Model.Dao.SellerDao;
import Model.DaoImpl.sellerOperation;
import Model.entities.Goods;
import Model.entities.seller;

public class SellerService {
	sellerOperation s=new SellerDao();
	public seller selectSeller(String sellerid) {
		
		seller seller=s.selectSeller(sellerid);
		return seller;
	}
	public List<Goods> goodslist(String sellerid) {
		
		List<Goods> goodslist=s.viewGoods(sellerid);
		return goodslist;
	}
	public void creategood(Goods g) {
		s.createGood(g.getGoodsid(), g.getGoodsname(), String.valueOf(g.getAmount()), String.valueOf(g.getPrice()), g.getSellerid(),g.getDescription());
	}
	public void deletegood(String goodid) {
		s.deleteGood(goodid);
	}
	public void updategood(Goods g) {
		
		s.updateGood(g.getGoodsid(), g.getGoodsname(), String.valueOf(g.getAmount()), String.valueOf(g.getPrice()), g.getDescription());
	}

}
