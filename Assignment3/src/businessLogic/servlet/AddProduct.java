package businessLogic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.Mediator;
import businessLogic.beans.Product;
import cqrs.writeModel.ProductWriteModel;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/add")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private ProductWriteModel writeModel;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProduct() {
		super();
		Mediator mediator=new Mediator();
		this.writeModel=new ProductWriteModel(mediator);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/addProduct.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String photo = request.getParameter("photo");
		String price = request.getParameter("price");
		String category = request.getParameter("category");
		String quantity = request.getParameter("quantity");


		Product product=new Product();
		product.setCode(code);
		product.setCategory(category);
		product.setName(name);
		product.setPhoto(photo);
		product.setPrice(Double.parseDouble(price));
		product.setQuantity(Integer.parseInt(quantity));
		String msg=writeModel.addProduct(product);

		if(msg.equals("SUCCESS"))  
		{
			request.getRequestDispatcher("/products").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage",msg);
			request.getRequestDispatcher("/addProduct.jsp").forward(request, response);
		}
	}

}
