package businessLogic.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.LoginDAO;
import businessLogic.beans.User;
import businessLogic.utils.MyUtils;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	// Show Login page.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher= this.getServletContext().getRequestDispatcher("/login.jsp");

		dispatcher.forward(request, response);

	}

	// When the user enters userName & password, and click Submit.
	// This method will be executed.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);

		User user =new User();
		user.setUserName(userName);
		user.setPassword(password);
		LoginDAO loginDao=new LoginDAO();
		String validate=loginDao.LoginCheck(user);
		if(validate.equals("Admin_Role"))
		 {
		 System.out.println("Admin's Home");
		 
		 HttpSession session ;//Creating a session
         if(request.getSession(false) == null) {
              session = request.getSession(true);
         } else {
             session = request.getSession(false);
         }
		 session.setAttribute("Admin", userName); //setting session attribute
		 request.setAttribute("userName", userName);
		 MyUtils.storeLoginedUser(session, user);
		 
         // If user checked "Remember me".
         if (remember) {
             MyUtils.storeUserCookie(response, user);
         }
         // Else delete cookie.
         else {
             MyUtils.deleteUserCookie(response);
         }
		 
		 request.getRequestDispatcher("/Admin.jsp").forward(request, response);
		 }
		 else if(validate.equals("Staff_Role"))
		 {
		 System.out.println("Staff's Home");
		 
		 HttpSession session ;//Creating a session
         if(request.getSession(false) == null) {
              session = request.getSession(true);
         } else {
             session = request.getSession(false);
         }
		 session.setAttribute("Staff", userName);
		 request.setAttribute("userName", userName);
		 MyUtils.storeLoginedUser(session, user);
		 
         // If user checked "Remember me".
         if (remember) {
             MyUtils.storeUserCookie(response, user);
         }
         // Else delete cookie.
         else {
             MyUtils.deleteUserCookie(response);
         }
		 
		 request.getRequestDispatcher("/Staff.jsp").forward(request, response);
		 }
		 else if(validate.equals("User_Role"))
		 {
		 System.out.println("User's Home");
		 
		 HttpSession session ;//Creating a session
         if(request.getSession(false) == null) {
              session = request.getSession(true);
         } else {
             session = request.getSession(false);
         }
		 session.setMaxInactiveInterval(10*60);
		 session.setAttribute("User", userName);
		 request.setAttribute("userName", userName);
		 MyUtils.storeLoginedUser(session, user);
		 
         // If user checked "Remember me".
         if (remember) {
             MyUtils.storeUserCookie(response, user);
         }
         // Else delete cookie.
         else {
             MyUtils.deleteUserCookie(response);
         }
		 
		 request.getRequestDispatcher("/User.jsp").forward(request, response);
		 }
		 else
		 {
		 System.out.println("Error message = "+validate);
		 request.setAttribute("errMessage", validate);
		 request.getRequestDispatcher("/login.jsp").forward(request, response);
		 }
	}

}