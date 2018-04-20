package Controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Dao.UserDao;
import Model.DaoImpl.UserOperation;
import Model.entities.Goods;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.service.CustomerService;

/**
 * Servlet implementation class orderServlet
 */
@WebServlet("/orderServlet")
public class orderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String deleteid=request.getParameter("deleteid");
		if(deleteid!=null) {
		List<Goods> Goodslist=(List<Goods>) request.getSession().getAttribute("cart");
		Goodslist.remove(Integer.parseInt(deleteid));
		//response.sendRedirect("/Finalprojectnew/cart.jsp");
		}
		
		String goodid=request.getParameter("goodid");
		CustomerService custs=new CustomerService();
		Goods g=custs.viewGooddetail(goodid);
		if(request.getSession().getAttribute("cart")==null) {
			List<Goods> Goodslist=new ArrayList<Goods>();
			//Goodslist.add(g);
			request.getSession().setAttribute("cart", Goodslist);
	       // response.sendRedirect("/Finalprojectnew/cart.jsp");
		}
		
			List<Goods> Goodslist=(List<Goods>) request.getSession().getAttribute("cart");
			List<Goods> Goodslist2=new ArrayList<Goods>();
			Goodslist.add(g);
			for(int i=0;i<Goodslist.size();i++) {
				if(Goodslist.get(i).getGoodsname()!=null) {
					Goodslist2.add(Goodslist.get(i));
				}
			}
			request.getSession().setAttribute("cart", Goodslist2);
	       // response.sendRedirect("/Finalprojectnew/cart.jsp");
		response.sendRedirect("/Finalprojectnew/cart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
