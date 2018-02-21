package testWebProject.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AuthenticationServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession httpSession = request.getSession();
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String query = "from Login login where loginId=? and password=?";
		Query queryObj = session.createQuery(query);
		queryObj.setString(0, username);
		queryObj.setString(1, password);
		List<User> records = queryObj.list();

		if (records.size() > 0) // if they have an account
		{
			request.setAttribute("loginstatus", "Login Successful.");
			System.out.println("'%s' logged in successfully!");
			httpSession.setAttribute("username", username);
			try
			{
				getServletContext().getRequestDispatcher("/application/home.jsp").forward(request, response);
			}
			catch (ServletException | IOException e)
			{
				e.printStackTrace();
			}

		}
		else
		{
			request.setAttribute("loginstatus", "Username/Password do not match.");
			try
			{
				getServletContext().getRequestDispatcher("/authentication/login.jsp").forward(request, response);
			}
			catch (ServletException | IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
