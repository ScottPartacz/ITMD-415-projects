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
 * Servlet implementation class viewandupdateuserServlet
 */
@WebServlet("/viewandupdateuserServlet")
public class viewandupdateuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewandupdateuserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdministratorService admin=new AdministratorService();
		if(request.getParameter("deletecid")!=null) {
			String deletecid=request.getParameter("deletecid");
			admin.deletecustomer(deletecid);
		}
		if(request.getParameter("deletesid")!=null) {
			String deletesid=request.getParameter("deletesid");
			admin.deleteseller(deletesid);
		}
		if(request.getParameter("updateid")!=null) {
			String updateid=request.getParameter("updateid");
			String role=request.getParameter("role");
			request.getSession().setAttribute("role", role);
			request.getSession().setAttribute("updateid", updateid);
			response.sendRedirect("/Finalprojectnew/UpdateUser.jsp");
		}else if(request.getParameter("viewid").equals("customers")) {
			List<customer> clist=admin.ViewCustomers();
			request.getSession().setAttribute("clist", clist);
	        response.sendRedirect("/Finalprojectnew/indexAdministrator.jsp");
		}else if(request.getParameter("viewid").equals("sellers")) {
			List<seller> slist=admin.ViewSellers();
			request.getSession().setAttribute("slist", slist);
	        response.sendRedirect("/Finalprojectnew/indexAdministrator.jsp");
		}else {
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
