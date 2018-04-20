package Controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.service.AdministratorService;
import Controller.service.CustomerService;
import Controller.service.LoginService;
import Controller.service.SellerService;
import Model.entities.Goods;
import Model.entities.Order;
import Model.entities.customer;
import Model.entities.seller;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u=null;
		if(!request.getParameter("userid").equals("")&&!request.getParameter("password").equals("")&&!request.getParameter("role").equals("")) {
        String userid=request.getParameter("userid");
        String password=request.getParameter("password");
        String role=request.getParameter("role");
        
        LoginService service=new LoginService();
       if(role.equals("customer")) {
       u=service.SellectUser(userid, password, role);
        request.getSession().setAttribute("user", u);
        if(!u.equals("worry information")) {
        CustomerService Cservice=new CustomerService();
        
        List<Goods> glist=Cservice.viewGoodslist();
        SellerService s=new SellerService();
        List<seller> sellerlist=new ArrayList<seller>();
        for(int i=0;i<glist.size();i++) {
        	seller seller=s.selectSeller(glist.get(i).getSellerid());
        	sellerlist.add(seller);
        }
        request.getSession().setAttribute("userid",userid );
        request.getSession().setAttribute("glist", glist);
        request.getSession().setAttribute("sellerlist", sellerlist);
        request.getSession().setAttribute("role", role);
        response.sendRedirect("/Finalprojectnew/indexCustomer.jsp");
        }else {
        	response.sendRedirect("/Finalprojectnew/index.jsp");
        }
		}else if(role.equals("seller")){
			SellerService s=new SellerService();
			u=service.SellectUser(userid, password, role);
	        request.getSession().setAttribute("user", u);
	        if(!u.equals("worry information")) {
	        CustomerService ser=new CustomerService();
	       List<Order>orderlist= ser.ViewOrders(role, userid);
	        request.getSession().setAttribute("orderlist",orderlist );
	        request.getSession().setAttribute("userid",userid );
	        request.getSession().setAttribute("role", role);
	        List<Goods> glist=s.goodslist(userid);
			request.getSession().setAttribute("glist", glist);
	        response.sendRedirect("/Finalprojectnew/Sellerindex.jsp");
	        }else {
	        	response.sendRedirect("/Finalprojectnew/index.jsp");
	        }
		}else {
			u=service.SellectUser(userid, password, role);
	        request.getSession().setAttribute("user", u);
	        if(!u.equals("worry information")) {
		        CustomerService ser=new CustomerService();
		        AdministratorService admin=new AdministratorService();
		       List<Order>orderlist= ser.ViewOrders(role, userid);
		        request.getSession().setAttribute("orderlist",orderlist );
		        request.getSession().setAttribute("userid",userid );
		        request.getSession().setAttribute("role", role);
				List<Goods>glist= ser.viewGoodslist();
				request.getSession().setAttribute("glist", glist);
				List<customer> clist=admin.ViewCustomers();
				request.getSession().setAttribute("clist", clist);
				List<seller> slist=admin.ViewSellers();
				request.getSession().setAttribute("slist", slist);
		        response.sendRedirect("/Finalprojectnew/indexAdministrator.jsp");
		        }else {
		        	response.sendRedirect("/Finalprojectnew/index.jsp");
		        }
		}
		}else {
			String userid="please input username";
			String role="please input role";
			String password="please input password";
			 request.getSession().setAttribute("userid",userid );
			 request.getSession().setAttribute("password", password);
			 request.getSession().setAttribute("role", role);
			 response.sendRedirect("/Finalprojectnew/index.jsp");
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
