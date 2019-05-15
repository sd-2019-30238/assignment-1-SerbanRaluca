package businessLogic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.Mediator;
import cqrs.writeModel.OrderWriteModel;

/**
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private OrderWriteModel writeModel;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FeedbackServlet() {
		super();
		Mediator mediator=new Mediator();
		this.writeModel=new OrderWriteModel(mediator);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			doGet_display(request, response);
		} else {
			if (action.equalsIgnoreCase("feedback")) {
				doGet_feedback(request, response);
			}
		}
	}
	private void doGet_display(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/history.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet_feedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String feedback=request.getParameter("feedback");
		String msg=writeModel.updateFeedback(feedback,request.getParameter("id"));
		if(msg.equalsIgnoreCase("SUCCESS")) {
			response.sendRedirect("thanks.jsp");
		}else {
			request.setAttribute("errMsg", msg);
			response.sendRedirect("feedback");
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
