package progetto;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class MailApp extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static boolean isDataSource = true;
	static ClientModel model;

	static {
		if (isDataSource) {
			model= new ClientModelDS();
		}
	}

	String email2  = "";
	String to ="";
	String subject = "";
	String message =  "";
	String user = "";
	String pass ="";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");		
		String action = request.getParameter("action");
		String page="/recovery.jsp";

		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}


		request.getSession().setAttribute("cart", cart);
		request.setAttribute("cart", cart);
		String var="true";

		request.setAttribute("verifica", var);


		try {

			if (action != null) {
				if (action.equalsIgnoreCase("recovery")) {
					email2= request.getParameter("email2");			

					if(model.Check(email2).equals("true")){
						page = "/home";

						to = email2;	
						subject = "Recupero Password";
						message =  model.getClient(email2).getPassword();
						user = "gdilcinese4@gmail.com";
						pass ="rf4131771sp";
						SendEmail.send(to,subject, message, user, pass);

					}else {
						var="false";
						request.setAttribute("verifica", var);
						page = "/recovery.jsp";
					}
				}}
		}
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}
}