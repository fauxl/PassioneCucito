package progetto;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import progetto.Cart;

public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static boolean isDataSource = true;
	static GadgetModel model;
	static OrdersModel model4;
	static GadgetModel model3;
	static {
		if (isDataSource) {
			model = new GadgetModelDS();
			model4 = new OrdersModelDS();
			model3 = new GadgetModelDS();
		}
	}
	String page = "";

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
		page = "/carrello.jsp";
		
		try {
			if (action != null) {
				if (action.equalsIgnoreCase("delete")) {
					boolean prova;
					String id = request.getParameter("id");
						prova = false;
						GadgetBean gadge = model3.doRetrieveByKey(id);
						List<GadgetBean> gadget = cart.getgadget(); 	
						for(GadgetBean gadg : gadget) {
							if(gadg.getcode().equals(id)) {
								gadg.setprice(gadg.getprice() - gadge.getprice());
								gadg.setquantity(gadg.quantity - 1);
								if (gadg.quantity == 0) {
									prova = true;
								}
							}
						}
						if (prova == true)
							cart.deleteGadget(model3.doRetrieveByKey(id));
					
	
					}
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
		request.setAttribute("email", model3.Getemail(email));

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
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
		request.setAttribute("email", model3.Getemail(email));
		String action = request.getParameter("action");
		try {
			if (action != null) {
				if (action.equalsIgnoreCase("shop")) {
					GregorianCalendar gc = new GregorianCalendar();
					String 	date = gc.get(Calendar.YEAR) + "/" +  gc.get(Calendar.MONTH) + "/" + gc.get(Calendar.DAY_OF_MONTH);
					String lol= "";
					Random randomGenerator = new Random();
					int randomInt = randomGenerator.nextInt(10000);
					lol = String.valueOf(randomInt);
					email = "noemail";
					if (request.getCookies() != null) {
						for (int i = 0; i < request.getCookies().length; i++) {
							if (request.getCookies()[i].getName().equals("email")) {
								email =  request.getCookies()[i].getValue();
							}
						}
					}
					String prezzo = request.getParameter("totale");
					if (!(email.equals("noemail"))) {
						if (!(prezzo.equals("0,00"))){
							model4.Shop(lol,date,email,prezzo);
							
							List<GadgetBean> gadgetscart = cart.getgadget(); 	
							for(GadgetBean bean2cart: gadgetscart) {
								model.Shopgadget(bean2cart.getcode(),lol,bean2cart.getquantity(),bean2cart.getavailability());
							}			   		
							cart = null;
							page="/order";
						}
					}
				}	
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		request.getSession().setAttribute("cart", cart);
		request.setAttribute("cart", cart);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);	
	}
}