package progetto;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddWishlistControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static boolean isDataSource = true;
	static GadgetModel model;
	static {
		if (isDataSource) {
			model = new GadgetModelDS();
		
		}
	}

	public AddWishlistControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		request.getSession().setAttribute("cart", cart);
		request.setAttribute("cart", cart);
		
		String action = request.getParameter("action");
		String page = "";

		try {
			if (action != null) {
				String email = "noemail";
				if (request.getCookies() != null) {
					for (int i = 0; i < request.getCookies().length; i++) {
						if (request.getCookies()[i].getName().equals("email")) {
							email =  request.getCookies()[i].getValue();
						}
					}
				}
				String id = request.getParameter("id");
			
					page = "/oggetto";
					model.doAddGadget(id, email);
			
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		String email = "noemail";
		if (request.getCookies() != null) {
			for (int i = 0; i < request.getCookies().length; i++) {
				if (request.getCookies()[i].getName().equals("email")) {
					email =  request.getCookies()[i].getValue();
				}
			}
		}
		request.removeAttribute("email");
		request.setAttribute("email", model.Getemail(email));

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}