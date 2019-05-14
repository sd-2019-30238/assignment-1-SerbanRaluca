package businessLogic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.AbstractDiscountCreator;
import businessLogic.Discount;
import businessLogic.DiscountCreator;
import businessLogic.Mediator;
import cqrs.readModel.ProductQueryService;
import cqrs.writeModel.ProductWriteModel;

/**
 * Servlet implementation class ProductOperations
 */
@WebServlet("/products")
public class ProductOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private ProductWriteModel writeModel;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductOperations() {
		super();
		Mediator mediator=new Mediator();
		writeModel=new ProductWriteModel(mediator);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null) {
			doGetView(request, response);
		} else {
			if (action.equalsIgnoreCase("remove")) {
				doGet_Remove(request, response);
			} else if (action.equalsIgnoreCase("add")) {
				doGet_Add(request, response);
			} else if (action.equalsIgnoreCase("addDiscount")) {
				doGet_discount(request, response);
			}
		}
	}

	private void doGet_discount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AbstractDiscountCreator discountCreator=new DiscountCreator();
		Discount discount=discountCreator.createDiscount(request.getParameter("discount"));
		Double new_price=discount.applyDiscount(Double.parseDouble(request.getParameter("price")));
		writeModel.updatePrice(request.getParameter("code"), new_price);
		response.sendRedirect("products");

	}

	private void doGet_Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/addProduct.jsp");

		dispatcher.forward(request, response);

	}

	private void doGet_Remove(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String msg=writeModel.removeProduct(request.getParameter("code"));
			if(msg.equalsIgnoreCase("SUCCESS")) {
				response.sendRedirect("products");
			}else {
				request.setAttribute("errMessage", msg);
				response.sendRedirect("products");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGetView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setAttribute("products", ProductQueryService.queryProduct());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/products.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
