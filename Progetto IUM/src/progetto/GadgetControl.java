package progetto;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrdersControl
 */
public class GadgetControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// OrdersModelDS usa il DataSource
	// OrdersModelDM usa il DriverManager	
	static boolean isDataSource = true;
	static GadgetModel model;


	static {
		if (isDataSource) {
			model = new GadgetModelDS();
		}
	}

	public GadgetControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametro ="";
		String parametro2 ="";

		try {
			
			String sort = request.getParameter("sort");
			request.setAttribute("sort", sort);
			parametro = request.getParameter("publisher");
			parametro2 = request.getParameter("tipo");
			request.removeAttribute("gadgets");
			request.setAttribute("gadgets", model.doRetrieveAll(parametro2, parametro, sort));		
				
				
		
		}			
		catch (SQLException e) {
				System.out.println("Error:" + e.getMessage());
		}
		String action = request.getParameter("action");

		try {
			if (action != null) {
				if (action.equalsIgnoreCase("read")) {
					String sort = request.getParameter("sort");
			request.removeAttribute("oggetti");
			request.setAttribute("oggetti", model.doRetrieveAll(sort));
		}
				}
			}
			catch (SQLException e) {
				System.out.println("Error:" + e.getMessage());
			}	
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		

		request.getSession().setAttribute("cart", cart);
		request.setAttribute("cart", cart);
			
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gadget.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}