package progetto;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import progetto.ClientBean;
import progetto.ClientModelDS;

/**
 * Servlet implementation class ClientControl
 */
public class ClientControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// ClientModelDM usa il DriverManager	
	static boolean isDataSource = true;
	static ClientModel model;
	static GadgetModel model2;

	static {
		model = new ClientModelDS();			
		model2 = new GadgetModelDS();
	}

	public ClientControl() {
		super();
	}

	String page="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}

		

		request.getSession().setAttribute("cart", cart);
		request.setAttribute("cart", cart);
			
	
	
		
		 String email = "noemail";
			if (request.getCookies() != null) {
			       
			    for (int i = 0; i < request.getCookies().length; i++) {
			        if (request.getCookies()[i].getName().equals("email")) {
			        	
			        	email =  request.getCookies()[i].getValue();
			        	
			        }
			    }
			}   

			request.removeAttribute("email");
			request.setAttribute("email", model2.Getemail(email));
			
			try {
				email = "";
				if (request.getCookies() != null) {
				       
				    for (int i = 0; i < request.getCookies().length; i++) {
				        if (request.getCookies()[i].getName().equals("email")) {
				        	
				        	email =  request.getCookies()[i].getValue();
				        	
				        }
				}
					request.removeAttribute("client");
				request.setAttribute("client", model.getClient(email));	
			
				}
		}
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
	
	
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dati.jsp");
			dispatcher.forward(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String action = request.getParameter("action");
			 page="/dati.jsp";
			 String email3 = "noemail";

			 String email = "noemail";
				if (request.getCookies() != null) {
				       
				    for (int i = 0; i < request.getCookies().length; i++) {
				        if (request.getCookies()[i].getName().equals("email")) {
				        	
				        	email =  request.getCookies()[i].getValue();
				        	
				        }
				    }
				}   
				
				Cart cart = (Cart)request.getSession().getAttribute("cart");
				if(cart == null) {
					cart = new Cart();
					request.getSession().setAttribute("cart", cart);
				}
				

				request.getSession().setAttribute("cart", cart);
				request.setAttribute("cart", cart);
					
				
			
			if(email.equals("noemail")) {
			
			try {
				if (action != null) {
					if (action.equalsIgnoreCase("insert")) {
						String name = request.getParameter("name");
						String surname = request.getParameter("surname");
						String phone = request.getParameter("phone");
						String address = request.getParameter("address");
						String city = request.getParameter("city");
						String email2 = request.getParameter("email");
						String cap = request.getParameter("cap");
						String region = request.getParameter("region");
						String password = request.getParameter("password");
						String password2 = request.getParameter("password2");

						ClientBean bean = new ClientBean();
						bean.setPassword(password);
						bean.setRegion(region);
						bean.setCap(cap);
						bean.setName(name);
						bean.setSurname(surname);
						bean.setPhone(phone);
						bean.setAddress(address);
						bean.setCity(city);
						bean.setEmail(email2);

						if(password.equals(password2)){
							model.doSave(bean);
							page="/home";
						}

						request.removeAttribute("email");
						request.setAttribute("email", model2.Getemail(email3));
						 
					}
				}
			}
				catch (SQLException e) {
					System.out.println("Error:" + e.getMessage());
				}
			 
			} else {
				try {
					if (action != null) {
						if (action.equalsIgnoreCase("insert")) {
							String name = request.getParameter("name");
							String surname = request.getParameter("surname");
							String phone = request.getParameter("phone");
							String address = request.getParameter("address");
							String city = request.getParameter("city");
							String email2 = request.getParameter("email");
							String cap = request.getParameter("cap");
							String region = request.getParameter("region");
							String password = request.getParameter("password");
							String password2 = request.getParameter("password2");

							ClientBean bean = new ClientBean();
							bean.setPassword(password);
							bean.setRegion(region);
							bean.setCap(cap);
							bean.setName(name);
							bean.setSurname(surname);
							bean.setPhone(phone);
							bean.setAddress(address);
							bean.setCity(city);
					

							if(password.equals(password2)){
								model.doUpdate(bean, email2);
								page="/home";
							}

							request.removeAttribute("email");
							request.setAttribute("email", model2.Getemail(email3));
							 
						}
					}
				}
					catch (SQLException e) {
						System.out.println("Error:" + e.getMessage());
					}	
			}
				
			try {
				email = "";
				if (request.getCookies() != null) {
				       
				    for (int i = 0; i < request.getCookies().length; i++) {
				        if (request.getCookies()[i].getName().equals("email")) {
				        	
				        	email =  request.getCookies()[i].getValue();
				        	
				        }
				}
					request.removeAttribute("client");
				request.setAttribute("client", model.getClient(email));	
			
				}
		}
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
				dispatcher.forward(request, response);
				}

	}