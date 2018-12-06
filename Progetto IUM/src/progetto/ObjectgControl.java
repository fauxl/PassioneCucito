package progetto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrdersControl
 */
public class ObjectgControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// OrdersModelDS usa il DataSource
	// OrdersModelDM usa il DriverManager	
	static boolean isDataSource = true;
	static GadgetModel model;
	static RecensioneModel model2;
	
	static {
		if (isDataSource) {
			model = new GadgetModelDS();
			model2 = new RecensioneModelDS();


		}
	}

	public ObjectgControl() {
		super();
	}


	
	   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}

		request.getSession().setAttribute("cart", cart);
		request.setAttribute("cart", cart);
		
		try {
					String id = request.getParameter("id");
					request.removeAttribute("oggetto");
					request.setAttribute("oggetto", model.doRetrieveByKey(id));
				}
		
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}	
	
		String action = request.getParameter("action");
		try {
			if (action != null) {
				if (action.equalsIgnoreCase("read")) {
					String id = request.getParameter("id");
					request.removeAttribute("id");
					request.setAttribute("id", id);
					request.removeAttribute("oggetto");
					request.setAttribute("oggetto", model.doRetrieveByKey(id));
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}	

		try {
		String	id = request.getParameter("id");
					model.doRetrieveByKey(id);
					String sort = model.doRetrieveByKey(id).getcategory();
			request.removeAttribute("oggetti");
			request.setAttribute("oggetti", model.doRetrieveAll(sort));
			request.removeAttribute("reviews");
			request.setAttribute("reviews", model2.doRetrieveAll(id));
			
		}
	
			catch (SQLException e) {
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
	

			try {		
				if (action != null) {
					if (action.equalsIgnoreCase("insertrev")) {
						String description= request.getParameter("description");
						String code = request.getParameter("id");
	
						RecensioneBean bean = new RecensioneBean();
						bean.setdescription2(description);
						bean.setcode(code);
						bean.setEmail(email);
					
							model2.doSaveRev(bean);
							request.removeAttribute("reviews");
							request.setAttribute("reviews", model2.doRetrieveAll(code));
						
					}
				}
				}
		
				catch (SQLException e) {
					System.out.println("Error:" + e.getMessage());
				}
			
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/oggettog.jsp");
		dispatcher.forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}


		request.getSession().setAttribute("cart", cart);
		request.setAttribute("cart", cart);
		

		try {
					String id = request.getParameter("id");
					request.removeAttribute("oggetto");
					request.setAttribute("oggetto", model.doRetrieveByKey(id));
		}
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}	
	}
	}
