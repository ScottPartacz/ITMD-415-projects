package Controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controller.service.SellerService;
import Controller.service.Userservice;
import Model.entities.Cars;
import Model.entities.Order;
import Model.entities.seller;

/**
 * Servlet implementation class orderServlet3
 */
@WebServlet("/orderServlet3")
public class orderServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderid=request.getParameter("orderid");
		Userservice u=new Userservice();
		SellerService s=new SellerService();
		Order o=u.viewOrderDetails(orderid);
		String gl=o.getcarid();
		String[] glist=gl.trim().split(" ");
		List<Cars> Carslist=new ArrayList<Cars>();
		List<seller> sellerlist=new ArrayList<seller>();
		for(int i=0;i<glist.length;i++) {
		
			Carslist.add(u.carDetail(glist[i]));
		}
		for(int i=0;i<Carslist.size();i++) {
			sellerlist.add(s.selectSeller(Carslist.get(i).getSellerid()));
		}
		request.getSession().setAttribute("sellerlist2", sellerlist);
		request.getSession().setAttribute("Carsdetail", Carslist);
		request.getSession().setAttribute("orderdetail", o);
		response.sendRedirect("/Finalprojectnew/OrderDetail.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
