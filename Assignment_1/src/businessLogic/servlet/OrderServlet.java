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
import javax.servlet.http.HttpSession;

import businessLogic.OrderDAO;
import businessLogic.beans.Item;
import businessLogic.beans.Order;
import businessLogic.utils.DBUtils;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/order.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String zipcode=request.getParameter("zipcode");
		String country=request.getParameter("country");
		//Double total=Double.parseDouble(request.getParameter("total"));
		Double total=0.0;

		System.out.println("aici");

		if(firstname.length() >45) {
			request.setAttribute("errMessage", "First name cannot be more than 45 characters long.");
			request.getRequestDispatcher("/CheckoutPage.jsp").forward(request, response);
			return;
		}

		if(lastname.length() >45) {
			request.setAttribute("errMessage", "Last name cannot be more than 45 characters long.");
			request.getRequestDispatcher("/CheckoutPage.jsp").forward(request, response);
			return;
		}

		if(address.length() >45) {
			request.setAttribute("errMessage", " Address cannot be more than 45 characters long.");
			request.getRequestDispatcher("/CheckoutPage.jsp").forward(request, response);
			return;
		}

		if(city.length() >45) {
			request.setAttribute("errMessage", "City cannot be more than 45 characters long.");
			request.getRequestDispatcher("/CheckoutPage.jsp").forward(request, response);
			return;
		}

		if(zipcode.length() >45) {
			request.setAttribute("errMessage", "Zipcode cannot be more than 45 characters long.");
			request.getRequestDispatcher("/CheckoutPage.jsp").forward(request, response);
			return;
		}

		if(country.length() >45) {
			request.setAttribute("errMessage", "Country  cannot be more than 45 characters long.");
			request.getRequestDispatcher("/CheckoutPage.jsp").forward(request, response);
			return;
		}

		Order order=new Order();
		order.setAddress(address);
		order.setCity(city);
		order.setCountry(country);
		order.setFirst_name(firstname);
		order.setLast_name(lastname);
		order.setZipcode(zipcode);
	
        String m="";
		HttpSession session=request.getSession();
		@SuppressWarnings("unused")
		List<Item> cart= (List<Item>) session.getAttribute("cart");
		for(int i=0;i<cart.size();i++) {
			Double price=cart.get(i).getProduct().getPrice();
			int quantity=cart.get(i).getQuantity();
			total+=price*quantity;
			String code=cart.get(i).getProduct().getCode();
			int q=cart.get(i).getProduct().getQuantity();
			int newQuantity=q-quantity;
			try {
				m=DBUtils.updateProduct(code, newQuantity);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		session.removeAttribute("cart");
		System.out.println(total);
		order.setTotal(total);
		System.out.println("aici");
		OrderDAO orderDao=new OrderDAO();
		String msg=orderDao.placeOrder(order);

		if(msg.equals("SUCCESS") && m.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/order.jsp").forward(request, response);
		}
		else   //On Failure, display a meaningful message to the User.
		{
			request.setAttribute("errMessage", msg);
			request.getRequestDispatcher("/CheckoutPage.jsp").forward(request, response);
		}

	}


}
