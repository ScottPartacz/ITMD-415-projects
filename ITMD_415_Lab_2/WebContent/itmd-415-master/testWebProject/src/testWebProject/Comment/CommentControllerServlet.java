package testWebProject.Comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testWebProject.lib;

/**
 * Servlet implementation class CommentControllerServlet
 */
@WebServlet("/CommentControllerServlet")
public class CommentControllerServlet extends HttpServlet
{
	private static final long serialVersionUID = 2355545410566511934L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//response.getWriter().append(lib.wrap(String.format("'%s' aka Comment Controller Servlet FTW!",this.getClass().getName()),"p"));
		//response.getWriter().append(lib.wrap(String.format("Served at: %s",request.getContextPath()),"p"));
		
		log("Someone is GETing our CommentControllerServlet");
		
		request.getRequestDispatcher("/tests/comment/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String name = request.getParameter("name");
		String comment = request.getParameter("comment");
		long date = lib.nowEpochSecond();

		Comment c = new Comment(name, comment, date); // wrap their comment inside our Comment object
		
		CommentManager cm = new CommentManager();
		cm.setup();
		
		cm.create(c); // insert comment we just got from user
		
		try
		{
			cm.stop();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		response.sendRedirect("./"); // send them to the page to see their newly made comment
		
	}

}
