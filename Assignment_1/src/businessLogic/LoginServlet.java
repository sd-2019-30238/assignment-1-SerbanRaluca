package businessLogic;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.beans.User;

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

		// Forward to /WEB-INF/views/loginView.jsp
		// (Users can not access directly into JSP pages placed in WEB-INF)
		RequestDispatcher dispatcher //
		= this.getServletContext().getRequestDispatcher("/login.jsp");

		dispatcher.forward(request, response);

	}

	// When the user enters userName & password, and click Submit.
	// This method will be executed.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		//String rememberMeStr = request.getParameter("rememberMe");
		//boolean remember = "Y".equals(rememberMeStr);

		User user =new User();
		user.setUserName(userName);
		user.setPassword(password);
		LoginDAO loginDao=new LoginDAO();
		String str=loginDao.LoginCheck(user);
		if(str.equals("success")) {
			HttpSession session=request.getSession(true);
			session.setAttribute("session_user", userName);
			response.sendRedirect("Welcome.jsp");
			//RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Welcome.jsp");
			//dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}