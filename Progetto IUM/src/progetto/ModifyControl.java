package progetto;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class ModifyControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SAVE_DIR = "/WebContent/immagini";
	// ClientModelDM usa il DriverManager	
	static boolean isDataSource = true;
	static GadgetModel model;
	static GadgetModel model4;

	static {
		model = new GadgetModelDS();
		model4 = new GadgetModelDS();

	}

	public ModifyControl() {
		super();
	}

	String page="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String action = request.getParameter("action");
		page="/modificaprodotto.jsp";
		
		try {
			request.removeAttribute("oggetto");
			GadgetBean oggetto2 = new GadgetBean();
			request.setAttribute("oggetto", oggetto2);
			
		
			
			if (action != null) {
				if (action.equalsIgnoreCase("read")) {
					String id = request.getParameter("id");
			
						request.removeAttribute("oggetto");
						request.setAttribute("oggetto", model4.doRetrieveByKey3(id));
						
					
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
			
	
			RequestDispatcher dispatcher = getServletContext().
					getRequestDispatcher(page);
			dispatcher.forward(request, response);
			
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		
				//PrintWriter out = response.getWriter();
				response.setContentType("text/plain");
				
				String action = request.getParameter("action");
				String savePath = SAVE_DIR;

				File fileSaveDir = new File(savePath);
				if (!fileSaveDir.exists()) {
					fileSaveDir.mkdir();
				}

				
				String db="";
				if( request.getParts() != null && request.getParts().size() > 0) {
				for (Part part : request.getParts()) {
					String fileName = extractFileName(part);
					if (fileName != null && !fileName.equals("")) {
						part.write(savePath + File.separator + fileName);
						db = "\"immagini/" + fileName + "\"";
					
					} 
					}
				
				}
				
				try {
					request.removeAttribute("oggetto");
					GadgetBean oggetto2 = new GadgetBean();
					request.setAttribute("oggetto", oggetto2);
					
				
					
					if (action != null) {
						if (action.equalsIgnoreCase("read")) {
							String id = request.getParameter("id");
								request.removeAttribute("oggetto");
								request.setAttribute("oggetto", model4.doRetrieveByKey3(id));
								
							
						}
					}
				}
				catch (SQLException e) {
					System.out.println("Error:" + e.getMessage());
				}
				
				
			
				try {		
					if (action != null) {
						if (action.equalsIgnoreCase("modifyg")) {
							String code = request.getParameter("codeg");
							String name = request.getParameter("name");
							String type = request.getParameter("typeg");
							float price = Float.parseFloat(request.getParameter("priceg"));
							String weight = request.getParameter("weight");
							String dimension = request.getParameter("dimension");
							String publisher = request.getParameter("publisherg");
							String description = request.getParameter("description");
							int availabilityg = Integer.parseInt(request.getParameter("availabilityg"));
			
							GadgetBean bean = new GadgetBean();
							bean.setname(name);
							bean.settype(type);
							bean.setprice(price);
							bean.setcategory(weight);
							bean.setdimension(dimension);
							bean.setpublisher(publisher);
							bean.setdescription(description);
							if (db.equals("")){
							bean.setimage(model4.doRetrieveByKey3(code).getimage());
						}
						else {
							bean.setimage(db);
						}
							bean.setavailability(availabilityg);


							page="/deleteproduct";
								model.doUpdateG(bean, code);
							
						}
					}
					}
			
					catch (SQLException e) {
						System.out.println("Error:" + e.getMessage());
					}
				
			
				RequestDispatcher dispatcher = getServletContext().
						getRequestDispatcher(page);
				dispatcher.forward(request, response);
				
			}

			private String extractFileName(Part part) {
				//content-disposition: form-data; name="file"; filename="file.txt"
				String contentDisp = part.getHeader("content-disposition");
				String[] items = contentDisp.split(";");
				for (String s : items) {
					if (s.trim().startsWith("filename")) {
						return s.substring(s.indexOf("=") + 2, s.length() - 1);
					}
				}
				return "";
			}
			
		}
	