

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Servlet implementation class ValidateFormDate
 */
@WebServlet("/ValidateFormDate")
public class ValidateFormDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ValidateFormDate() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		
		HttpSession session = request.getSession();
		
		
		String email = request.getParameter("email");
		String  zip = request.getParameter("zip");
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String  address = request.getParameter("street");
		String state = request.getParameter("state");
		String ssn = request.getParameter("ssn");
		
		session.setAttribute("email", email);
		session.setAttribute("zip", zip);
		session.setAttribute("name", name);
		session.setAttribute("city", city);
		session.setAttribute("address:", address);
		session.setAttribute("state", state);
		session.setAttribute("ssn", ssn);
		
		boolean vaild;
		
		check:
		if(email.length() > 7 && zip.length() == 10 && zip.charAt(5) == '-')
		{
			for(int i = 0; i < zip.length(); i++)
	        {
				if((Character.isDigit(zip.charAt(i))))
                {
					vaild = true;
                }
				
				else
				{
					vaild = false;
					break check;
				}
	        }
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
			if( matcher.matches())
			{
				vaild = true;
			}
			
			else
			{
				vaild = false;
			}
		}
		else
		{
			vaild = false;
		}
		
		
		if(vaild)
		{
			String nextJSP = "/ProcessCustomerDataRequest.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
		}
		
		else
		{
			System.out.println("Your zipcode or email was invaild");
			String nextJSP = "/GetFormData.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
		}
		
	}

}
