package progetto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrdersControl
 */
public class AddCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static boolean isDataSource = true;
	static GadgetModel model2;
	static {
		if (isDataSource) {
			model2 = new GadgetModelDS();
		}
	}

	public AddCartControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String page = "";
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}

		try {
			if (action != null) {
				String id = request.getParameter("id");
				boolean prova;

					page = "/oggetto";
					prova = true;
					List<GadgetBean> gadget = cart.getgadget(); 	
					for (GadgetBean gadg : gadget) {
						if (gadg.getcode().equals(id)) {
							gadg.setquantity(gadg.getquantity()+1);
							GadgetBean gadge = model2.doRetrieveByKey(id);
							gadg.setprice(gadg.getprice()+gadge.getprice());
							prova = false;
						} else {
							prova = true;
						}
					}
					if (prova == true) {
						cart.addGadget(model2.doRetrieveByKey(id));
					}
				
						
					
				}
			
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}