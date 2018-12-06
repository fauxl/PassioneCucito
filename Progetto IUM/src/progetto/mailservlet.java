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
public class mailservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// OrdersModelDS usa il DataSource
	// OrdersModelDM usa il DriverManager	
	static boolean isDataSource = true;



public mailservlet() {
	super();
}

String email2  = "";
String to ="";
String subject = "";
String message =  "";
String user = "";
String pass ="";

protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	
	String action = request.getParameter("action");
	String page="/contattaci.jsp";

	Cart cart = (Cart)request.getSession().getAttribute("cart");
	if(cart == null) {
		cart = new Cart();
		request.getSession().setAttribute("cart", cart);
	}
	

	request.getSession().setAttribute("cart", cart);
	request.setAttribute("cart", cart);
		



	

	if (action != null) {
	if (action.equalsIgnoreCase("mailus")) {

		   to = request.getParameter("email2");	
		   subject = request.getParameter("object");
		    message =  request.getParameter("message");
		     user = "gdilcinese4@gmail.com";
		  pass ="rf4131771sp";
		   SendEmail.send(to,subject, message, user, pass);

			page = "/home.jsp";
		}
	}
	

	
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
dispatcher.forward(request, response);

}



protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
doGet(request, response);
}
}