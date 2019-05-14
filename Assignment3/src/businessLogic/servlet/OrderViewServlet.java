package businessLogic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cqrs.readModel.OrderQueryService;
import businessLogic.beans.Observer;
import businessLogic.beans.OrderObserver;

/**
 * Servlet implementation class OrderViewServlet
 */
@WebServlet("/orders")
public class OrderViewServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	private List<Observer> observers;

	
	public OrderViewServlet() {
		super();
		this.observers=new ArrayList<Observer>();
		OrderObserver observer=new OrderObserver();
		this.registerObserver(observer);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			doGet_display(request, response);
		} else {
			if (action.equalsIgnoreCase("update")) {
				doGet_Update(request, response);
			}
		}
	}

	private void doGet_Update(HttpServletRequest request, HttpServletResponse response) {

			String id=request.getParameter("id");
			String state=request.getParameter("state");
	        for (Observer o:observers){
	        	o.update(id, state);
	        }
			try {
				response.sendRedirect("orders");
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet_display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("orders", OrderQueryService.selectOrders());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/orders.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	public void registerObserver(Observer o) {
		this.observers.add(o);
	}

	public void removeObserver(Observer o) {
		this.observers.remove(o);	
	}

}
