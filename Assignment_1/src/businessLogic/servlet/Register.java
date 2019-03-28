package businessLogic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import businessLogic.RegisterDAO;
import businessLogic.beans.*;
import businssLogic.validators.EmailValidator;
import businssLogic.validators.NumberValidator;

/**
 * Servlet implementation class Register
 */
@WebServlet(urlPatterns = { "/register"})
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/register1.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
        if(first_name.length() >45) {
            request.setAttribute("errMessage", "First name cannot be more than 45 characters long.");
            request.getRequestDispatcher("/register1.jsp").forward(request, response);
            return;
        }
        
        if(last_name.length() >45) {
            request.setAttribute("errMessage", "Last name cannot be more than 45 characters long.");
            request.getRequestDispatcher("/register1.jsp").forward(request, response);
            return;
        }
        
        if(username.length() >45) {
            request.setAttribute("errMessage", " Username cannot be more than 45 characters long.");
            request.getRequestDispatcher("/register1.jsp").forward(request, response);
            return;
        }
        
        if(password.length() >45) {
            request.setAttribute("errMessage", "Password cannot be more than 45 characters long.");
            request.getRequestDispatcher("/register1.jsp").forward(request, response);
            return;
        }
        
        if(address.length() >45) {
            request.setAttribute("errMessage", "Address cannot be more than 45 characters long.");
            request.getRequestDispatcher("/register1.jsp").forward(request, response);
            return;
        }
        
        if(email.length() >45) {
            request.setAttribute("errMessage", "Email  cannot be more than 45 characters long.");
            request.getRequestDispatcher("/register1.jsp").forward(request, response);
            return;
        }
        
        if(contact.length() >10) {
            request.setAttribute("errMessage", "Contact number cannot be more than 10 characters long.");
            request.getRequestDispatcher("/register1.jsp").forward(request, response);
            return;
        }
        
        
		User user=new User(first_name,last_name,email,username,password,address,contact);
		 EmailValidator validator1=new EmailValidator();
		 try {
	        validator1.validate(user);
		 }catch(IllegalArgumentException e) {
			 String msg=e.getMessage();
			 request.setAttribute("errMessage",msg);
			 request.getRequestDispatcher("/register1.jsp").forward(request, response);
	         return;
		 }
		 NumberValidator validator2=new NumberValidator();
		 try {
	        validator2.validate(user);
		 }catch(IllegalArgumentException e) {
			 String msg=e.getMessage();
			 request.setAttribute("errMessage",msg);
			 request.getRequestDispatcher("/register1.jsp").forward(request, response);
	         return;
		 }
		RegisterDAO registerDao=new RegisterDAO();
		String userRegistered=registerDao.registerUser(user);
		
		if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
		}
		else   //On Failure, display a meaningful message to the User.
		{
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/register1.jsp").forward(request, response);
		}
	}

}
