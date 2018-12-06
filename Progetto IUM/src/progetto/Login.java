package progetto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
/*
import java.io.PrintWriter;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;
*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static boolean isDataSource = true;
	static  GadgetModel model;
	static ClientModel model2;


	static {
		if (isDataSource) {
			model =  new GadgetModelDS();
			model2 = new ClientModelDS();
		}
	}
	
	public Login() {
		super();
	}
	String email2  = "";
	String page="";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		 page="/login.jsp";


Cart cart = (Cart)request.getSession().getAttribute("cart");
if(cart == null) {
	cart = new Cart();
	request.getSession().setAttribute("cart", cart);
}

request.getSession().setAttribute("cart", cart);
request.setAttribute("cart", cart);
String var="true";

request.setAttribute("verifica", var);


	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String action = request.getParameter("action");

	
		String email3 = "noemail";

		request.removeAttribute("email");
		request.setAttribute("email", model.Getemail(email3));
		 
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}


request.getSession().setAttribute("cart", cart);
request.setAttribute("cart", cart);
	

		
		try {
		
				
			if (action != null) {
				if (action.equalsIgnoreCase("check")) {
					email2= request.getParameter("email2");			
					request.getSession().setAttribute("NewUser", email2);
					request.getSession().setAttribute("verifica", "false");

					if(model2.Check(email2).equals("true")){
						page ="/login.jsp";
						String var="false";

						request.setAttribute("verifica", var);
					}else {
						page = "/client";
						

					}
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
					dispatcher.forward(request, response);	
					
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		if (action != null) {
			if (action.equalsIgnoreCase("login")) {
		if (ClientModelDS.checkUser(email, pass)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("attempt", "true");
			session.setAttribute("email", email);
			request.getSession().setAttribute("RegisteredUserRoles", new Boolean(true));

			Cookie cookieAttempt = new Cookie("attempt", "true");
			cookieAttempt.setMaxAge(60*60*24*365);
			
			response.addCookie(cookieAttempt);	
			
			Cookie cookieEmail= new Cookie("email", email);
			cookieEmail.setMaxAge(60*60*24*365);
			response.addCookie(cookieEmail);

			response.sendRedirect("myaccount");
		} else if (ClientModelDS.checkAdmin(email, pass)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("attempt", "true");
			session.setAttribute("email", email);
			request.getSession().setAttribute("adminRoles", new Boolean(true));

			
			Cookie cookieAttempt = new Cookie("attempt", "true");
			cookieAttempt.setMaxAge(60*60*24*365);
			response.addCookie(cookieAttempt);	
			
			Cookie cookieEmail= new Cookie("email", email);
			cookieEmail.setMaxAge(60*60*24*365);
			response.addCookie(cookieEmail);

			response.sendRedirect("manageraccount");	
		}
		else {
			Cookie cookieAttempt= new Cookie("attempt", "false");
			cookieAttempt.setMaxAge(1);
			response.addCookie(cookieAttempt); 
			response.sendRedirect("login");
		}
	}}
		}
}