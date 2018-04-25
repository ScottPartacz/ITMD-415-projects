package Controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Dao.UserDao;
import Model.DaoImpl.UserOperation;
import Model.entities.Cars;
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
		List<Cars> Carslist=(List<Cars>) request.getSession().getAttribute("cart");
		Carslist.remove(Integer.parseInt(deleteid));
		//response.sendRedirect("/Finalprojectnew/cart.jsp");
		}
		
		String carid=request.getParameter("carid");
		CustomerService custs=new CustomerService();
		Cars g=custs.viewcardetail(carid);
		if(request.getSession().getAttribute("cart")==null) {
			List<Cars> Carslist=new ArrayList<Cars>();
			//Carslist.add(g);
			request.getSession().setAttribute("cart", Carslist);
	       // response.sendRedirect("/Finalprojectnew/cart.jsp");
		}
		
			List<Cars> Carslist=(List<Cars>) request.getSession().getAttribute("cart");
			List<Cars> Carslist2=new ArrayList<Cars>();
			Carslist.add(g);
			for(int i=0;i<Carslist.size();i++) {
				if(Carslist.get(i).getModel()!=null) {
					Carslist2.add(Carslist.get(i));
				}
			}
			request.getSession().setAttribute("cart", Carslist2);
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
