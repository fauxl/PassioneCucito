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

public class RecensioneModelDS implements RecensioneModel{
	
	private static DataSource ds;

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/merceria");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	public synchronized String Getemail(String email) {
		return email;
	}

	
	@Override
	public synchronized Collection<RecensioneBean> doRetrieveAll(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<RecensioneBean> reviews = new LinkedList<RecensioneBean>();

		String selectSQL = "Select * from Recensione, Prodotto where recensione.COD_PRODOTTO = prodotto.COD_PRODOTTO and prodotto.COD_PRODOTTO=?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
			RecensioneBean bean = new RecensioneBean();

				bean.setdescription(rs.getString("DESCRIZIONE"));
				bean.setEmail(rs.getString("E_MAIL"));
				bean.setcode(rs.getString("COD_PRODOTTO"));
				reviews.add(bean);
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
		return reviews;
	}
	
	@Override
	public synchronized boolean doDeleteReview(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM Recensione  WHERE COD_PRODOTTO = ?";

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
	public synchronized void doSaveRev(RecensioneBean Recensione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO Recensione"
				+ " (DESCRIZIONE, COD_PRODOTTO, E_MAIL) "
				+ "VALUES (?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, Recensione.getdescription2());
			preparedStatement.setString(2, Recensione.getcode());
			preparedStatement.setString(3, Recensione.getEmail());


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
	public synchronized Collection<RecensioneBean> doRetrieveAllArea(String e_mail) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<RecensioneBean> reviews = new LinkedList<RecensioneBean>();

		String selectSQL = "Select * from Recensione, Prodotto, Cliente where recensione.COD_PRODOTTO = prodotto.COD_PRODOTTO and recensione.E_MAIL=Cliente.E_MAIL and Cliente.E_MAIL=?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, e_mail);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
			RecensioneBean bean = new RecensioneBean();

				bean.setimage(rs.getString("IMMAGINI"));
				bean.setname(rs.getString("NOME"));
				bean.setcode(rs.getString("COD_PRODOTTO"));
				bean.setdescription2(rs.getString("DESCRIZIONE"));
				bean.setEmail(rs.getString("E_MAIL"));
				bean.setcode(rs.getString("COD_PRODOTTO"));
				reviews.add(bean);
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
		return reviews;
	}


}
