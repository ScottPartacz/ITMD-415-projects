package Controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.service.AdministratorService;
import Controller.service.CustomerService;
import Controller.service.Userservice;
import Model.entities.Goods;
import Model.entities.Order;

/**
 * Servlet implementation class orderServlet2
 */
@WebServlet("/orderServlet2")
public class orderServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String orderid, String Customerid, String sellerid, List<Goods> goodslist, String status,Date date
		CustomerService custs=new CustomerService();
		Userservice u=new Userservice();
		AdministratorService ad=new AdministratorService();
		String Customerid=(String) request.getSession().getAttribute("userid");
		if(request.getSession().getAttribute("role").equals("customer")) {
		if(request.getSession().getAttribute("cart")!=null) {
		List<Goods> Goodslist=(List<Goods>) request.getSession().getAttribute("cart");
		String sellerid="";
		String status="non-payment";
		Date d=new Date();
		for(int i=0;i<Goodslist.size();i++) {
			sellerid+=Goodslist.get(i).getSellerid()+" ";
		}

		int m=(int) (Math.random()*100000);
		String orderid3=String.valueOf(m);
		
		custs.createOrder(orderid3,  sellerid, Customerid,Goodslist, status, d);
		}
		List<Float> pricelist=new ArrayList<Float>();
		String orderid=null;
		String orderid2=null;
		
		if(request.getParameter("cancelorderid")!=null) {
			
			 orderid=request.getParameter("cancelorderid");
			custs.cancelOrder(orderid);
		}
        if(request.getParameter("payorderid")!=null) {
			 orderid2=request.getParameter("payorderid");
			custs.payforOrder(orderid2);
		}
		
		List<Order>orderlist=custs.ViewOrders("customer", Customerid);
		for(int i=0;i<orderlist.size();i++) {
			float price=0;
			String[]gs= orderlist.get(i).getGoodid().split(" ");
			for(int q=0;q<gs.length;q++) {
				price+=u.goodDetail(gs[q]).getPrice();
			}
			pricelist.add(price);
		}
		request.getSession().removeAttribute("cart");
		request.getSession().setAttribute("pricelist", pricelist);
		request.getSession().setAttribute("orderlist", orderlist);
		request.getSession().setAttribute("orderlist", orderlist);
		request.getSession().setAttribute("payorderid", orderid2);
		request.getSession().setAttribute("cancelorderid", orderid);
		if(request.getParameter("cancelorderid")!=null) {
		response.sendRedirect("/Finalprojectnew/cancelSuccess.jsp");
		}else if(request.getParameter("payorderid")!=null) {
		response.sendRedirect("/Finalprojectnew/paySuccess.jsp");
		}else {
		response.sendRedirect("/Finalprojectnew/CustomerAccount.jsp");
		}
		
		
		}else if(request.getSession().getAttribute("role").equals("seller")) {
			String sellerid=(String) request.getSession().getAttribute("userid");
			if(request.getParameter("cancelorderid")!=null) {
				String orderid=request.getParameter("cancelorderid");
				custs.cancelOrder(orderid);
				List<Order> orderlist=custs.ViewOrders("seller", sellerid);
				request.getSession().setAttribute("orderlist", orderlist);
				response.sendRedirect("/Finalprojectnew/Sellerindex.jsp");
			}
		}else {
			if(request.getParameter("deleteorderid")!=null) {
				ad.deleteorder(request.getParameter("deleteorderid"));
			}
			String role=(String)request.getSession().getAttribute("role");
			String adminid=(String) request.getSession().getAttribute("userid");
			List<Order>orderlist= custs.ViewOrders(role, adminid);
			request.getSession().setAttribute("orderlist", orderlist);
			response.sendRedirect("/Finalprojectnew/indexAdministrator.jsp");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
