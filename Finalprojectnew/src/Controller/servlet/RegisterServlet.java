package Controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.service.CustomerService;
import Controller.service.LoginService;
import Controller.service.SellerService;
import Controller.service.Userservice;
import Model.entities.Cars;
import Model.entities.Order;
import Model.entities.seller;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println(request.getParameter("userid")+request.getParameter("role"));
		LoginService logins=new LoginService();
		if(!request.getParameter("userid").equals("")&&!request.getParameter("password").equals("")&&!request.getParameter("role").equals("")) {
			String userid=request.getParameter("userid");
			String username=request.getParameter("username");
			String role=request.getParameter("role");
			String password=request.getParameter("password");
			String address=request.getParameter("address");
			Userservice us=new Userservice();
			boolean boo= us.createuser(role, userid, username, address, password);
			//System.out.println(boo);
			if(boo&&role.equals("customer")) {
				 CustomerService Cservice=new CustomerService();
			        List<Cars> glist=Cservice.viewCarslist();
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
			        
			        LoginService service=new LoginService();
					String u=service.SellectUser(userid, password, role);
			        request.getSession().setAttribute("user", u);
			        response.sendRedirect("/Finalprojectnew/indexCustomer.jsp");
			}else if(boo&&role.equals("seller")) {
				CustomerService ser=new CustomerService();
				
			       List<Order>orderlist= ser.ViewOrders(role, userid);
			        request.getSession().setAttribute("orderlist",orderlist );
			        request.getSession().setAttribute("userid",userid );
			        request.getSession().setAttribute("role", role);
			        
			        LoginService service=new LoginService();
					String u=service.SellectUser(userid, password, role);
			        request.getSession().setAttribute("user", u);
			        response.sendRedirect("/Finalprojectnew/Sellerindex.jsp");
			}else {
					   request.getSession().setAttribute("uid", "This userid has been used by other people!");
					   response.sendRedirect("/Finalprojectnew/index.jsp");
			}
			//request.getSession().setAttribute("boo", boo);
		}else {
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
