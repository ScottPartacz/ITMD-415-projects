package Controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.service.CustomerService;
import Controller.service.SellerService;
import Model.entities.Cars;
import Model.entities.seller;

/**
 * Servlet implementation class CarsServlet
 */
@WebServlet("/CarsServlet")
public class CarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerService custservice=new CustomerService();
		 SellerService s=new SellerService();
		 if(request.getParameter("deletecarid") != null) {
				String carid=request.getParameter("deletecarid");
				s.deletecar(carid);
			}
		if(((String)request.getSession().getAttribute("role")).equals("customer")) {
		String carid=request.getParameter("id");
		
		Cars g=custservice.viewcardetail(carid);
		
		seller seller= s.selectSeller(g.getSellerid());
		request.getSession().setAttribute("car", g);
		request.getSession().setAttribute("seller", seller);
		response.sendRedirect("/Finalprojectnew/Carsdetails.jsp");
		}else if(((String)request.getSession().getAttribute("role")).equals("seller")) {
			String sellerid=(String)request.getSession().getAttribute("userid");
			if(request.getParameter("sellercarid") != null) {
				String carid=request.getParameter("sellercarid");
				Cars g=custservice.viewcardetail(carid);
				seller seller= s.selectSeller(g.getSellerid());
				request.getSession().setAttribute("car", g);
				request.getSession().setAttribute("seller", seller);
				response.sendRedirect("/Finalprojectnew/SellerCarsdetail.jsp");
			}else if(request.getParameter("updatecarid") != null){
				if(request.getParameter("addcarname")!=null
						&&request.getParameter("addamount")!=null&&request.getParameter("addprice")!=null) {
					    
					Cars g=new Cars();
					g.setCarid(request.getParameter("updatecarid"));
					g.setmodelname(request.getParameter("addcarname"));
					g.setAmount(Integer.parseInt(request.getParameter("addamount")));
					g.setPrice(Float.parseFloat(request.getParameter("addprice")));
					g.setSellerid((String) request.getSession().getAttribute("userid"));
					g.setDescription((String)request.getParameter("description"));
					s.updatecar(g);
					request.getSession().setAttribute("car", g);
				}
				
				List<Cars> glist=s.Carslist(sellerid);
				request.getSession().setAttribute("glist", glist);
				response.sendRedirect("/Finalprojectnew/SellerCarsdetail.jsp");
				
			}else {
			
			
			if(request.getParameter("addcarid")!=null&&request.getParameter("addcarname")!=null
					&&request.getParameter("addamount")!=null&&request.getParameter("addprice")!=null) {
				   if(custservice.viewcardetail(request.getParameter("addcarid"))!=null) {
					   request.getSession().setAttribute("gid", " create fail! please change a new carid");
				   } 
				Cars g=new Cars();
				g.setCarid(request.getParameter("addcarid"));
				g.setmodelname(request.getParameter("addcarname"));
				g.setAmount(Integer.parseInt(request.getParameter("addamount")));
				g.setPrice(Float.parseFloat(request.getParameter("addprice")));
				g.setSellerid((String) request.getSession().getAttribute("userid"));
				g.setDescription((String)request.getParameter("description"));
				s.createcar(g);
				
			}
			List<Cars> glist=s.Carslist(sellerid);
			request.getSession().setAttribute("glist", glist);
			response.sendRedirect("/Finalprojectnew/Sellerindex.jsp");
			}
		}else if(((String)request.getSession().getAttribute("role")).equals("administrator")){
			if(request.getParameter("sellercarid") != null) {
				String carid=request.getParameter("sellercarid");
				Cars g=custservice.viewcardetail(carid);
				seller seller= s.selectSeller(g.getSellerid());
				request.getSession().setAttribute("car", g);
				request.getSession().setAttribute("seller", seller);
				response.sendRedirect("/Finalprojectnew/SellerCarsdetail.jsp");
			}else if(request.getParameter("updatecarid") != null){
				if(request.getParameter("addcarname")!=null
						&&request.getParameter("addamount")!=null&&request.getParameter("addprice")!=null) {
					    
					Cars g=new Cars();
					g.setCarid(request.getParameter("updatecarid"));
					g.setmodelname(request.getParameter("addcarname"));
					g.setAmount(Integer.parseInt(request.getParameter("addamount")));
					g.setPrice(Float.parseFloat(request.getParameter("addprice")));
					g.setSellerid((String) request.getSession().getAttribute("userid"));
					g.setDescription((String)request.getParameter("description"));
					s.updatecar(g);
					request.getSession().setAttribute("car", g);
				}
				List<Cars>glist= custservice.viewCarslist();
				request.getSession().setAttribute("glist", glist);
				response.sendRedirect("/Finalprojectnew/SellerCarsdetail.jsp");
				
			}else {
			List<Cars>glist= custservice.viewCarslist();
			request.getSession().setAttribute("glist", glist);
			response.sendRedirect("/Finalprojectnew/indexAdministrator.jsp");
			}
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
