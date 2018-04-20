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
import Model.entities.Goods;
import Model.entities.seller;

/**
 * Servlet implementation class goodsServlet
 */
@WebServlet("/goodsServlet")
public class goodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsServlet() {
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
		 if(request.getParameter("deletegoodid") != null) {
				String goodid=request.getParameter("deletegoodid");
				s.deletegood(goodid);
			}
		if(((String)request.getSession().getAttribute("role")).equals("customer")) {
		String goodid=request.getParameter("id");
		
		Goods g=custservice.viewGooddetail(goodid);
		
		seller seller= s.selectSeller(g.getSellerid());
		request.getSession().setAttribute("good", g);
		request.getSession().setAttribute("seller", seller);
		response.sendRedirect("/Finalprojectnew/goodsdetails.jsp");
		}else if(((String)request.getSession().getAttribute("role")).equals("seller")) {
			String sellerid=(String)request.getSession().getAttribute("userid");
			if(request.getParameter("sellergoodid") != null) {
				String goodid=request.getParameter("sellergoodid");
				Goods g=custservice.viewGooddetail(goodid);
				seller seller= s.selectSeller(g.getSellerid());
				request.getSession().setAttribute("good", g);
				request.getSession().setAttribute("seller", seller);
				response.sendRedirect("/Finalprojectnew/Sellergoodsdetail.jsp");
			}else if(request.getParameter("updategoodid") != null){
				if(request.getParameter("addgoodname")!=null
						&&request.getParameter("addamount")!=null&&request.getParameter("addprice")!=null) {
					    
					Goods g=new Goods();
					g.setGoodsid(request.getParameter("updategoodid"));
					g.setGoodsname(request.getParameter("addgoodname"));
					g.setAmount(Integer.parseInt(request.getParameter("addamount")));
					g.setPrice(Float.parseFloat(request.getParameter("addprice")));
					g.setSellerid((String) request.getSession().getAttribute("userid"));
					g.setDescription((String)request.getParameter("description"));
					s.updategood(g);
					request.getSession().setAttribute("good", g);
				}
				
				List<Goods> glist=s.goodslist(sellerid);
				request.getSession().setAttribute("glist", glist);
				response.sendRedirect("/Finalprojectnew/Sellergoodsdetail.jsp");
				
			}else {
			
			
			if(request.getParameter("addgoodid")!=null&&request.getParameter("addgoodname")!=null
					&&request.getParameter("addamount")!=null&&request.getParameter("addprice")!=null) {
				   if(custservice.viewGooddetail(request.getParameter("addgoodid"))!=null) {
					   request.getSession().setAttribute("gid", " create fail! please change a new goodid");
				   } 
				Goods g=new Goods();
				g.setGoodsid(request.getParameter("addgoodid"));
				g.setGoodsname(request.getParameter("addgoodname"));
				g.setAmount(Integer.parseInt(request.getParameter("addamount")));
				g.setPrice(Float.parseFloat(request.getParameter("addprice")));
				g.setSellerid((String) request.getSession().getAttribute("userid"));
				g.setDescription((String)request.getParameter("description"));
				s.creategood(g);
				
			}
			List<Goods> glist=s.goodslist(sellerid);
			request.getSession().setAttribute("glist", glist);
			response.sendRedirect("/Finalprojectnew/Sellerindex.jsp");
			}
		}else if(((String)request.getSession().getAttribute("role")).equals("administrator")){
			if(request.getParameter("sellergoodid") != null) {
				String goodid=request.getParameter("sellergoodid");
				Goods g=custservice.viewGooddetail(goodid);
				seller seller= s.selectSeller(g.getSellerid());
				request.getSession().setAttribute("good", g);
				request.getSession().setAttribute("seller", seller);
				response.sendRedirect("/Finalprojectnew/Sellergoodsdetail.jsp");
			}else if(request.getParameter("updategoodid") != null){
				if(request.getParameter("addgoodname")!=null
						&&request.getParameter("addamount")!=null&&request.getParameter("addprice")!=null) {
					    
					Goods g=new Goods();
					g.setGoodsid(request.getParameter("updategoodid"));
					g.setGoodsname(request.getParameter("addgoodname"));
					g.setAmount(Integer.parseInt(request.getParameter("addamount")));
					g.setPrice(Float.parseFloat(request.getParameter("addprice")));
					g.setSellerid((String) request.getSession().getAttribute("userid"));
					g.setDescription((String)request.getParameter("description"));
					s.updategood(g);
					request.getSession().setAttribute("good", g);
				}
				List<Goods>glist= custservice.viewGoodslist();
				request.getSession().setAttribute("glist", glist);
				response.sendRedirect("/Finalprojectnew/Sellergoodsdetail.jsp");
				
			}else {
			List<Goods>glist= custservice.viewGoodslist();
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
