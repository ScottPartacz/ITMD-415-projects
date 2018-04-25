package Controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.service.AdministratorService;
import Model.entities.customer;
import Model.entities.seller;

/**
 * Servlet implementation class SelfUpdateServlet
 */
@WebServlet("/SelfUpdateServlet")
public class SelfUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
  
		String userid=(String) request.getSession().getAttribute("userid");
		String username=request.getParameter("username");
		String role=(String) request.getSession().getAttribute("role");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		System.out.println(userid+" "+username+" "+password+" "+address);
		AdministratorService s=new AdministratorService();
		s.updateuser(role, userid, username, password, address);
	 if(role.equals("customer")) {
		 request.getSession().setAttribute("user", username);
	        response.sendRedirect("/Finalprojectnew/CustomerAccount.jsp");
		}else if(role.equals("seller")) {
			request.getSession().setAttribute("user", username);
	        response.sendRedirect("/Finalprojectnew/Sellerindex.jsp");
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
