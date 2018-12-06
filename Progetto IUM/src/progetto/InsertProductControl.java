package progetto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;

import javax.servlet.http.Part;
import javax.servlet.annotation.*;


public class InsertProductControl  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SAVE_DIR2 = "/home/fauxl/Dropbox/ProgettoWeb/WebContent/immagini";
	private static final String SAVE_DIR ="C:/Users/FauxL/Dropbox/ProgettoWeb/WebContent/immagini";



	static boolean isDataSource = true;
	static GadgetModel model;

	static {
		model = new GadgetModelDS();
	}

	public InsertProductControl() {
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
			
	
		
			RequestDispatcher dispatcher = getServletContext().
					getRequestDispatcher("/inserisciprodotto.jsp");
			dispatcher.forward(request, response);
			
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		
			Cart cart = (Cart)request.getSession().getAttribute("cart");
			if(cart == null) {
				cart = new Cart();
				request.getSession().setAttribute("cart", cart);
			}
			

			request.getSession().setAttribute("cart", cart);
			request.setAttribute("cart", cart);
				
		
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
					if (action != null) {
						if (action.equalsIgnoreCase("insertg")) {
							String code = request.getParameter("codeg");
							String name = request.getParameter("name");
							String type = request.getParameter("typeg");
							float price = Float.parseFloat(request.getParameter("priceg"));
							String category = request.getParameter("weight");
							String dimension = request.getParameter("dimension");
							String publisher = request.getParameter("publisherg");
							String description = request.getParameter("description");
							int availabilityg = Integer.parseInt(request.getParameter("availabilityg"));

						
							
							GadgetBean bean = new GadgetBean();
							bean.setcode(code);
							bean.setname(name);
							bean.settype(type);
							bean.setprice(price);
							bean.setcategory(category);
							bean.setdimension(dimension);
							bean.setpublisher(publisher);
							bean.setdescription(description);
							bean.setimage(db);
							bean.setavailability(availabilityg);

								model.doSaveG(bean);
							
						}
					}
					}
			
					catch (SQLException e) {
						System.out.println("Error:" + e.getMessage());
					}
				
			
				
				RequestDispatcher dispatcher = getServletContext().
						getRequestDispatcher("/inserisciprodotto.jsp");
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

