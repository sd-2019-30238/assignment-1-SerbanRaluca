package businessLogic.servlet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.DiscountShoppingCart;
import businessLogic.Mediator;
import businessLogic.ShoppingCart;
import businessLogic.ShoppingCartDecorator;
import businessLogic.ShoppingCartImpl;
import businessLogic.beans.Item;
import businessLogic.beans.Order;
import businessLogic.utils.MyUtils;
import cqrs.writeModel.OrderWriteModel;
import cqrs.writeModel.ProductWriteModel;

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
		Double total=0.0;


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
		UUID id = UUID.randomUUID();
		order.setId(id);
		order.setAddress(address);
		order.setCity(city);
		order.setCountry(country);
		order.setFirst_name(firstname);
		order.setLast_name(lastname);
		order.setZipcode(zipcode);
		order.setState("receptionata");
		Mediator mediator=new Mediator();
		ProductWriteModel productModel=new ProductWriteModel(mediator);
		OrderWriteModel orderModel=new OrderWriteModel(mediator);

		HttpSession session=request.getSession();
		order.setUsername(MyUtils.getLoginedUser(session).getUserName());

		//calculate total
		List<Item> cart= (List<Item>) session.getAttribute("cart");
		ShoppingCart shoppingCart=new ShoppingCartImpl(cart,productModel);
		if(shoppingCart.getTotal()>1000) {
			request.setAttribute("total",shoppingCart.getTotal());
		}
		ShoppingCartDecorator cartDecorator=new DiscountShoppingCart(shoppingCart);
		total=cartDecorator.getTotal();
		request.setAttribute("discountTotal", total);

		session.removeAttribute("cart");
		order.setTotal(total);
		String msg=orderModel.placeOrder(order);

		if(msg.equals("SUCCESS"))  
		{
			request.getRequestDispatcher("/order.jsp").forward(request, response);
		}
		else 
		{
			request.setAttribute("errMessage", msg);
			request.getRequestDispatcher("/CheckoutPage.jsp").forward(request, response);
		}

	}


}
