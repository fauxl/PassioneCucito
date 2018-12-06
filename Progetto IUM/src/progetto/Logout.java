package progetto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Logout() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		request.getSession().removeAttribute("adminRoles");
		request.getSession().invalidate();		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Proponevo di far riconoscere al NAV il cookie:
		 * se è false allora esce la scritta "accedi"
		 * se è true facciamo uscire "Il tuo account"
		 */
		Cookie[] cookies= request.getCookies();

		for(Cookie cookie: cookies) {
			
			if(	(cookie.getName().equalsIgnoreCase("attempt")))
				
				cookie.setMaxAge(0);
				
			if(	(cookie.getName().equalsIgnoreCase("email")))
					
					cookie.setMaxAge(0);	
				
			
			
			response.addCookie(cookie);
			
		}
		
		response.sendRedirect("home");
		
	}

}
