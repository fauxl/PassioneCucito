package progetto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import progetto.GadgetBean;

public class GadgetModelDS implements GadgetModel {
	private static DataSource ds;

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/merceria");
		}
		catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	@Override
	public  synchronized boolean doAddGadget(String code,String email)throws SQLException {

	Connection connection = null;
	PreparedStatement preparedStatement = null;

	int result = 0;
			
	if (!(email.equals("noemail"))) {
	
	String deleteSQL = "INSERT Wishlist_Prodotto VALUES (?,?);";

	try {
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setString(1, code);
		preparedStatement.setString(2, email);
	
		result = preparedStatement.executeUpdate();

		
	} finally {
		try {
			if (preparedStatement != null){
				preparedStatement.close(); 

		}
		} finally {
			if (connection != null ){
				connection.close();
			}
			}
	}
	return (result != 0);
	}
	
	return false;
}

	
	

	
	
	@Override
	public synchronized boolean doDeleteGadget(String code, String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM  Wishlist_Prodotto WHERE COD_PRODOTTO = ? and E_MAIL = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, code);
			preparedStatement.setString(2, email);
		
			result = preparedStatement.executeUpdate();

			
		} finally {
			try {
				if (preparedStatement != null){
					preparedStatement.close(); 

			}
			} finally {
				if (connection != null ){
					connection.close();
				}
				}
		}
		return (result != 0);
	}
	

	@Override
	public synchronized GadgetBean doRetrieveByKey3(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		GadgetBean bean = new GadgetBean();
		String selectSQL = "SELECT * FROM " + GadgetModelDS.TABLE_NAME + " WHERE COD_PRODOTTO = ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, code);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setcode(rs.getString("COD_PRODOTTO"));
				bean.setprice(rs.getFloat("COSTO"));
				bean.setdimension(rs.getString("DIMENSIONI"));
				bean.setcategory(rs.getString("CATEGORIA"));
				bean.settype(rs.getString("TIPO"));
				bean.setpublisher(rs.getString("PUBLISHER"));
				bean.setdescription(rs.getString("DESCRIZIONE"));
				bean.setname(rs.getString("NOME"));
				bean.setimage(rs.getString("IMMAGINI"));
				bean.setavailability(rs.getInt("DISPONIBILITA"));

			}
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			}
			finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}
	public String verifica() {
		String fatto = "fatto";
		
		return fatto;
		
	}
	
	public String verifica2() {
		String fatto = "fatto2";
		
		return fatto;
		
	}
	

	@Override
	public synchronized void doSaveG(GadgetBean Gadget) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO Gadget"
				+ " (COD_GADGET, TIPO, PESO, COSTO, DIMENSIONI, NOME, PUBLISHER, DESCRIZIONE, IMMAGINI, CONFRONTO, DISPONIBILITA) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, false,?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, Gadget.getcode());
			preparedStatement.setString(2, Gadget.gettype());
			preparedStatement.setString(3, Gadget.getcategory());
			preparedStatement.setFloat(4, Gadget.getprice());
			preparedStatement.setString(5, Gadget.getdimension());
			preparedStatement.setString(6, Gadget.getname());
			preparedStatement.setString(7, Gadget.getpublisher());
			preparedStatement.setString(8, Gadget.getdescription());
			preparedStatement.setString(9, Gadget.getimage());
			
			preparedStatement.setInt(10, Gadget.getavailability());


			preparedStatement.executeUpdate();
			connection.commit();
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			}
			finally {
				if (connection != null)
					connection.close();
			}
		}
	}
	
	
	
	@Override
	public synchronized void doUpdateG(GadgetBean Gadget, String codgadget) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "Update Gadget set TIPO=?, PESO=?, COSTO=?, DIMENSIONI=?, NOME=?, PUBLISHER=?, DESCRIZIONE=?, IMMAGINI=?, DISPONIBILITA=? where COD_GADGET=? ";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, Gadget.gettype());
			preparedStatement.setString(2, Gadget.getcategory());
			preparedStatement.setFloat(3, Gadget.getprice());
			preparedStatement.setString(4, Gadget.getdimension());
			preparedStatement.setString(5, Gadget.getname());
			preparedStatement.setString(6, Gadget.getpublisher());
			preparedStatement.setString(7, Gadget.getdescription());
			preparedStatement.setString(8, Gadget.getimage());
			preparedStatement.setInt(9, Gadget.getavailability());
			preparedStatement.setString(10, codgadget);


			preparedStatement.executeUpdate();
			connection.commit();
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			}
			finally {
				if (connection != null)
					connection.close();
			}
		}
	}
			

	@Override
	public synchronized boolean doDelete(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM Fumetto WHERE COD_FUMETTO = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, code);

			result = preparedStatement.executeUpdate();

			
		} finally {
			try {
				if (preparedStatement != null){
					preparedStatement.close(); 

			}
			} finally {
				if (connection != null ){
					connection.close();
				}
				}
		}
		return (result != 0);
	}
	
	@Override
	public synchronized boolean doDeleteGadget(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM Gadget  WHERE COD_Gadget = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, code);
		
			result = preparedStatement.executeUpdate();

			
		} finally {
			try {
				if (preparedStatement != null){
					preparedStatement.close(); 

			}
			} finally {
				if (connection != null ){
					connection.close();
				}
				}
		}
		return (result != 0);
	}
	

	
	@Override
	public synchronized Collection<GadgetBean> doRetrieveAllG() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<GadgetBean> gadget = new LinkedList<GadgetBean>();
		String selectSQL = "select * from Gadget"; 
	
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
					GadgetBean bean = new GadgetBean();
					
						bean.setname(rs.getString("NOME"));
						bean.settype(rs.getString("TIPO"));
						bean.setcode(rs.getString("COD_GADGET"));
						bean.setprice(rs.getFloat("COSTO"));
						gadget.add(bean);			
				}
			}
		
	finally {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		}
		finally {
			if (connection != null)
				connection.close();
		}
	}
	return gadget;
	
}	
	public synchronized void Shopgadget(String gadget, String order, int quantity,int availability)
			throws SQLException {
		Connection connection4 = null;
		PreparedStatement preparedStatement4 = null;
		String insertSQL = "INSERT Articolato_da VALUES (?,?,?)";

		try {
			connection4 = ds.getConnection();
			preparedStatement4 = connection4.prepareStatement(insertSQL);
			preparedStatement4.setString(1, gadget);
			preparedStatement4.setString(3, order);
			preparedStatement4.setInt(2, quantity);
			preparedStatement4.executeUpdate();
		} finally {
			try {
				if (preparedStatement4 != null){
					preparedStatement4.close(); 
				}
			} finally {
				if (connection4 != null ){
					connection4.close();
				}
			}
		}
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int disponibilita = availability - quantity;
		String updateSQL = "Update Prodotto set DISPONIBILITA = ? where COD_PRODOTTO = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(2, gadget);
			preparedStatement.setInt(1, disponibilita);
			preparedStatement.executeUpdate();
		} finally {
			try {
				if (preparedStatement != null){
					preparedStatement.close(); 
				}
			} finally {
				if (connection != null ){
					connection.close();
				}
			}
		}
	}	


		public synchronized String Getemail(String email) {
			return email;
		}
	
	@Override
	public synchronized Collection<GadgetBean> doRetrieveAll3(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<GadgetBean> oggetti = new LinkedList<GadgetBean>();
		String selectSQL = "SELECT * FROM " + GadgetModelDS.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				GadgetBean bean = new GadgetBean();
				bean.setname(rs.getString("NOME"));
				bean.setcode(rs.getString("COD_PRODOTTO"));
				bean.settype(rs.getString("TIPO"));
				bean.setimage(rs.getString("IMMAGINI"));
				oggetti.add(bean);
			}
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			}
			finally {
				if (connection != null)
					connection.close();
			}
		}
		return oggetti;
	}
	
	@Override
	public synchronized boolean doDelete(String code, String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM Wishlist_Prodotto WHERE COD_Prodotto = ? and E_MAIL = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, code);
			preparedStatement.setString(2, email);
		
			result = preparedStatement.executeUpdate();

			
		} finally {
			try {
				if (preparedStatement != null){
					preparedStatement.close(); 

			}
			} finally {
				if (connection != null ){
					connection.close();
				}
				}
		}
		return (result != 0);
	}
	

	@Override
	public synchronized Collection<GadgetBean> doRetrieveAllG(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<GadgetBean> gadget = new LinkedList<GadgetBean>();
		String selectSQL = "select * from Prodotto, Cliente, Wishlist_Prodotto where Cliente.E_MAIL = Wishlist_Prodotto.E_MAIL and Prodotto.COD_PRODOTTO = Wishlist_Prodotto.COD_PRODOTTO and Cliente.E_MAIL = ?"; 
	
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, code);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
					GadgetBean bean = new GadgetBean();
					
						bean.setname(rs.getString("NOME"));
						bean.setcategory(rs.getString("CATEGORIA"));
						bean.setimage(rs.getString("IMMAGINI"));
						bean.settype(rs.getString("TIPO"));
						bean.setcode(rs.getString("COD_PRODOTTO"));
						bean.setprice(rs.getFloat("COSTO"));
						bean.setavailability(rs.getInt("DISPONIBILITA"));
						gadget.add(bean);			
				}
			}
		
	finally {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		}
		finally {
			if (connection != null)
				connection.close();
		}
	}
	return gadget;
	
}

	@Override
	public synchronized Collection<GadgetBean> doRetrieveAllOrders(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<GadgetBean> gadget = new LinkedList<GadgetBean>();
		String selectSQL = "select * from Prodotto, Ordine,  Articolato_da where Ordine.COD_ORDINE = Articolato_da.COD_ORDINE and Prodotto.COD_PRODOTTO = Articolato_da.COD_PRODOTTO and Articolato_da.COD_ORDINE= ?"; 
	
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, code);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
					GadgetBean bean = new GadgetBean();
					
						bean.setname(rs.getString("NOME"));
						bean.setimage(rs.getString("IMMAGINI"));
						bean.settype(rs.getString("TIPO"));
						bean.setquantity(rs.getInt("QUANTITA"));
						bean.setcode(rs.getString("COD_PRODOTTO"));
						bean.setprice(rs.getFloat("COSTO"));
						gadget.add(bean);			
				}
			}
		
	finally {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		}
		finally {
			if (connection != null)
				connection.close();
		}
	}
	return gadget;
	
}
	
	@Override
	public synchronized Collection<GadgetBean> doRetrieveAll2(String search) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<GadgetBean> gadget = new LinkedList<GadgetBean>();
		String selectSQL = "SELECT * FROM " + GadgetModelDS.TABLE_NAME;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				GadgetBean bean = new GadgetBean();

				boolean cerca = false;
				String stringa = rs.getString("NOME").toLowerCase();
				String sottostringa = search.toLowerCase();

				if (stringa.indexOf(sottostringa) != -1) {
					cerca = true;
				}

				if(cerca == true) {
					bean.setname(rs.getString("NOME"));
					bean.settype(rs.getString("TIPO"));
					bean.setcode(rs.getString("COD_GADGET"));
					bean.setimage(rs.getString("IMMAGINI"));
					gadget.add(bean);
				}	
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return gadget;
	}

	private static final String TABLE_NAME = "Prodotto";
	public synchronized GadgetBean doRetrieveByKey(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		GadgetBean bean = new GadgetBean();
		String selectSQL = "SELECT * FROM " + GadgetModelDS.TABLE_NAME + " WHERE COD_PRODOTTO = ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, code);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setcode(rs.getString("COD_PRODOTTO"));
				bean.setprice(rs.getFloat("COSTO"));
				bean.setdimension(rs.getString("DIMENSIONI"));
				bean.setcategory(rs.getString("CATEGORIA"));
				bean.settype(rs.getString("TIPO"));
				bean.setpublisher(rs.getString("PUBLISHER"));
				bean.setdescription(rs.getString("DESCRIZIONE"));
				bean.setname(rs.getString("NOME"));
				bean.setimage(rs.getString("IMMAGINI"));
				bean.setavailability(rs.getInt("DISPONIBILITA"));

			}
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			}
			finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}

	@Override
	public synchronized Collection<GadgetBean> doRetrieveAll(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<GadgetBean> gadget = new LinkedList<GadgetBean>();
		String selectSQL = "SELECT * FROM Prodotto where Prodotto.CATEGORIA=?";
		
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, code);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
					GadgetBean bean = new GadgetBean();
					
						bean.setname(rs.getString("NOME"));
						bean.settype(rs.getString("TIPO"));
						bean.setcode(rs.getString("COD_PRODOTTO"));
						bean.setimage(rs.getString("IMMAGINI"));
						gadget.add(bean);
						
				}
			}
		
	finally {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		}
		finally {
			if (connection != null)
				connection.close();
		}
	}
	return gadget;
	
}
	@Override
	public synchronized Collection<GadgetBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<GadgetBean> gadget = new LinkedList<GadgetBean>();
		String selectSQL = "SELECT * FROM Prodotto";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
					GadgetBean bean = new GadgetBean();
					
						bean.setname(rs.getString("NOME"));
						bean.settype(rs.getString("TIPO"));
						bean.setcode(rs.getString("COD_PRODOTTO"));
						bean.setimage(rs.getString("IMMAGINI"));
						gadget.add(bean);
					}
					
				
		
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			}
			finally {
				if (connection != null)
					connection.close();
			}
		}
		return gadget;
	}
	
	@Override
	public synchronized Collection<GadgetBean> doRetrieveAll(String tipo, String publisher, String sort) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<GadgetBean> gadget = new LinkedList<GadgetBean>();
		String selectSQL = "SELECT * FROM Prodotto where Prodotto.CATEGORIA=?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, sort);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
					GadgetBean bean = new GadgetBean();
					
					boolean cerca = true;
				
					if (publisher != null && tipo !=null){
					cerca = false;
					String stringa = rs.getString("TIPO").toLowerCase();
					String sottostringa = tipo.toLowerCase();

					if (stringa.indexOf(sottostringa) != -1) {
						cerca = true;
					}
					
					String stringa2 = rs.getString("PUBLISHER").toLowerCase();
					String sottostringa2 = publisher.toLowerCase();

					if (stringa2.indexOf(sottostringa2) != -1) {
						cerca = true;
					}
					
					}
					if(cerca == true) {
						bean.setname(rs.getString("NOME"));
						bean.settype(rs.getString("TIPO"));
						bean.setcode(rs.getString("COD_PRODOTTO"));
						bean.setimage(rs.getString("IMMAGINI"));
						gadget.add(bean);
					}
					
				}
			
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			}
			finally {
				if (connection != null)
					connection.close();
			}
		}
		return gadget;
	}
}