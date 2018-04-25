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
 * Servlet implementation class updateUserServlet
 */
@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdministratorService admin=new AdministratorService();
		String userid=(String) request.getSession().getAttribute("updateid");
		String username=request.getParameter("username");
		String role=(String) request.getSession().getAttribute("role");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		AdministratorService s=new AdministratorService();
		s.updateuser(role, userid, username, password, address);
	 if(role.equals("customer")) {
			List<customer> clist=admin.ViewCustomers();
			request.getSession().setAttribute("clist", clist);
	        response.sendRedirect("/Finalprojectnew/indexAdministrator.jsp");
		}else if(role.equals("seller")) {
			List<seller> slist=admin.ViewSellers();
			request.getSession().setAttribute("slist", slist);
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
