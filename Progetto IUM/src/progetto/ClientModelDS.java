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
//import javax.sql.DataSource;
import javax.sql.DataSource;

import progetto.ClientBean;

public class ClientModelDS implements ClientModel {

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
	}					/* */
	@Override
	public synchronized Collection<ClientBean> doRetrieveAll()
			throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ClientBean> oggetti = new LinkedList<ClientBean>();
		String selectSQL = "SELECT * FROM Cliente";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ClientBean bean = new ClientBean();
				String email = rs.getString("E_MAIL");
				if (!(email.equals("duckpro@libero.it"))) {
					bean.setName(rs.getString("NOME"));
					bean.setSurname(rs.getString("COGNOME"));
					bean.setEmail(rs.getString("E_MAIL"));
					bean.setNordini(rs.getInt("NUM_ORDINI"));
					bean.setPhone(rs.getString("CELLULARE"));
					oggetti.add(bean);
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
		return oggetti;
	}

	public boolean doDelete(String code)
			throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		String deleteSQL = "DELETE FROM  Cliente where E_MAIL = ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, code);
			result = preparedStatement.executeUpdate();
		}
		finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close(); 
				}
			}
			finally {
				if (connection != null ){
					connection.close();
				}
			}
		}
		return (result != 0);
	}
	@Override
	public synchronized String Check(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ClientBean> clients = new LinkedList<ClientBean>();
		String selectSQL = "SELECT * FROM  Cliente";
		
		String email2 ="";
		String check = "false";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				email2 = rs.getString("E_MAIL");
				
				if(email.equals(email2)) {
					check = "true";
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
	return check;
	}
	
	
	@Override
	public synchronized void doUpdate(ClientBean Client, String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE Cliente set NOME=?, COGNOME=?, NUM_ORDINI =0, PASS=?, CAP=?, CELLULARE=?, CITTA=?, INDIRIZZO=?, PROVINCIA=?" 
						+"WHERE E_MAIL=?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, Client.getName());
			preparedStatement.setString(2, Client.getSurname());
			preparedStatement.setString(3, Client.getPassword());
			preparedStatement.setString(4, Client.getCap());
			preparedStatement.setString(5, Client.getPhone());
			preparedStatement.setString(6, Client.getCity());
			preparedStatement.setString(7, Client.getAddress());
			preparedStatement.setString(8, Client.getRegion());
			preparedStatement.setString(9, email);
			
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
	public synchronized void doSave(ClientBean Client) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO Cliente"
				+ " (NOME, COGNOME, E_MAIL,NUM_ORDINI, PASS, CAP, CELLULARE, CITTA, INDIRIZZO, PROVINCIA) VALUES (?, ?, ?, 0, ?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, Client.getName());
			preparedStatement.setString(2, Client.getSurname());
			preparedStatement.setString(3, Client.getEmail());
			preparedStatement.setString(4, Client.getPassword());
			preparedStatement.setString(5, Client.getCap());
			preparedStatement.setString(6, Client.getPhone());
			preparedStatement.setString(7, Client.getCity());
			preparedStatement.setString(8, Client.getAddress());
			preparedStatement.setString(9, Client.getRegion());

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
	
					/*  */	
	public static boolean checkUser(String email,String pass) 
	{
		/** Indica se esiste una coppia email/password valida */
		
		boolean st = false;

			if(email != null && pass != null) {
				if(!(email.equals("duckpro@libero.it"))) {
		try {
			//loading drivers for mysql
			// Class.forName("com.mysql.jdbc.Driver");

			//Creating connection with the database 
			Connection con = DriverManagerConnectionPool.createDBConnection();
			PreparedStatement ps = con.prepareStatement
					("select * from Cliente where E_MAIL=? and PASS=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			st = rs.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				}
		return st; 
		
			}
			
			else { return false;}
			
			}
					
		

	
	
	
	public static boolean checkAdmin(String email,String pass) {
		/** Indica se esiste una coppia email/password valida */
		
		boolean st2 = false;

			if(email != null && pass != null) {
				if(email.equals("duckpro@libero.it")) {
		try {
			//loading drivers for mysql
			// Class.forName("com.mysql.jdbc.Driver");

			//Creating connection with the database 
			Connection con = DriverManagerConnectionPool.createDBConnection();
			PreparedStatement ps = con.prepareStatement
					("select * from Cliente where E_MAIL=? and PASS=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			st2 = rs.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
				}
		return st2; 
		
			}
			
			
			else { return st2;}
			
			}
	
	
	
					/* */
	
	public  synchronized ClientBean getClient(String email) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ClientBean bean= new	ClientBean();			
		String selectSQL = "select * from Cliente where E_MAIL=?";

		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
		
			while (rs.next()) {
			bean.setName(rs.getString("NOME"));
			bean.setSurname(rs.getString("COGNOME"));
			bean.setEmail(rs.getString("E_MAIL"));
			bean.setNordini(rs.getInt("NUM_ORDINI"));
			bean.setPassword(rs.getString("PASS"));
			bean.setCap(rs.getString("CAP"));
			bean.setPhone(rs.getString("CELLULARE"));
			bean.setCity(rs.getString("CITTA"));
			bean.setAddress(rs.getString("INDIRIZZO"));
			bean.setRegion(rs.getString("PROVINCIA"));
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
}