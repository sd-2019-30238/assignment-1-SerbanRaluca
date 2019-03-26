package businessLogic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.beans.Item;
import businessLogic.utils.DBUtils;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			doGet_DisplayCart(request, response);
		} else {
			if (action.equalsIgnoreCase("buy")) {
				try {
					doGet_Buy(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (action.equalsIgnoreCase("remove")) {
				doGet_Remove(request, response);
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if( session.getAttribute("cart") == null) {
			request.getRequestDispatcher("emptyCart.jsp").forward(request, response);
		}else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			if(cart.size()==0) {
				request.getRequestDispatcher("emptyCart.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("product/cartPage.jsp").forward(request, response);
			}
		}
	}

	protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = isExisting(request.getParameter("code"), cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart");
	}

	protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(DBUtils.findProduct(request.getParameter("code")), 1));
			session.setAttribute("cart", cart);
		} else {
			@SuppressWarnings("unchecked")
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = isExisting(request.getParameter("code"), cart);
			if (index == -1) {
				cart.add(new Item(DBUtils.findProduct(request.getParameter("code")), 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
		}
		response.sendRedirect("cart");
	}


	private int isExisting(String code, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getCode().equalsIgnoreCase(code)) {
				return i;
			}
		}
		return -1;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}