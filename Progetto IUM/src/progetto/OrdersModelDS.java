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

import progetto.OrdersBean;

public class OrdersModelDS implements OrdersModel {

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
	
	public synchronized int QuantityGadget(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int quantita = 1;

		String selectSQL = "select QUANTITA from Articolato_da where Formato_da.COD_GADGET= ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, code);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			quantita = rs.getInt("QUANTITA");
		
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
	return quantita;
}
	
	
	

	public synchronized Collection<OrdersBean>  doRetrieveAllAdmin() throws SQLException{
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdersBean> orders = new LinkedList<OrdersBean>();

		String selectSQL = "SELECT * FROM  Ordine";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdersBean bean = new OrdersBean();

				bean.setcode(rs.getString("COD_ORDINE"));
				bean.setemail(rs.getString("E_MAIL"));
				bean.setdate(rs.getString("DATA_ORDINE"));
				bean.settotal(rs.getString("COSTO_TOTALE"));
				bean.setstate(rs.getString("STATO"));
				bean.setpayment(rs.getString("PAGAMENTO"));
				orders.add(bean);
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
		return orders;
	}


	
	@Override
	public synchronized Collection<OrdersBean> doRetrieveAll(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdersBean> orders = new LinkedList<OrdersBean>();

		String selectSQL = "SELECT * FROM  Ordine where E_MAIL=?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdersBean bean = new OrdersBean();

				bean.setcode(rs.getString("COD_ORDINE"));
				bean.setdate(rs.getString("DATA_ORDINE"));
				bean.settotal(rs.getString("COSTO_TOTALE"));
				bean.setstate(rs.getString("STATO"));
				bean.setpayment(rs.getString("PAGAMENTO"));
				orders.add(bean);
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
		return orders;
	}
	public synchronized void Shop(String order,String date, String email, String prezzo)
			throws SQLException {
		if (!(email.equals("noemail"))) {
			Connection connection5 = null;
			PreparedStatement preparedStatement5 = null;
			String insertSQL2 = "INSERT Ordine VALUES (?,?,?,'completato','effettuato',?)"; 
			
			try {
				connection5 = ds.getConnection();
				preparedStatement5 = connection5.prepareStatement(insertSQL2);
				preparedStatement5.setString(1, date);
				preparedStatement5.setString(2, order);
				preparedStatement5.setString(3, prezzo);
				preparedStatement5.setString(4, email);
				preparedStatement5.executeUpdate();
			} finally {
				try {
					if (preparedStatement5 != null){
						preparedStatement5.close(); 
					}
				} finally {
					if (connection5 != null ){
						connection5.close();
					}
				}
			}
			Connection connection6 = null;
			PreparedStatement preparedStatement6 = null;
			String selectSQL3 = " Select NUM_ORDINI from Cliente where E_MAIL = ?"; 
			int nordini = 0;
			
			try {
				connection6 = ds.getConnection();
				preparedStatement6 = connection6.prepareStatement(selectSQL3);
				preparedStatement6.setString(1, email);
				ResultSet rs = preparedStatement6.executeQuery();

				if (rs.next()){
					nordini = rs.getInt("NUM_ORDINI");
					nordini = nordini +1;
				}
				Connection connection7 = null;
				PreparedStatement preparedStatement7 = null;	
				String updatesql = " Update Cliente set NUM_ORDINI = ? where E_MAIL= ?"; 
				
				try {
					connection7 = ds.getConnection();
					preparedStatement7 = connection7.prepareStatement(updatesql);
					preparedStatement7.setInt(1, nordini);
					preparedStatement7.setString(2, email);
					preparedStatement7.executeUpdate();
				} finally {
					try {
						if (preparedStatement7 != null)
							preparedStatement7.close();
					}
					finally {
						if (connection7 != null)
							connection7.close();
					}		
				}
			} finally {
				try {
					if (preparedStatement6 != null)
						preparedStatement6.close();
				}
				finally {
					if (connection6 != null)
						connection6.close();
				}
			}
		}
	}

	
}