package progetto;

import java.sql.SQLException;
import java.util.Collection;

import progetto.OrdersBean;

public interface OrdersModel {


	public int QuantityGadget(String code) throws SQLException;
	
	public void Shop(String order, String date,String email, String prezzo) throws SQLException;

	public Collection<OrdersBean> doRetrieveAll(String email) throws SQLException;

	public Collection<OrdersBean> doRetrieveAllAdmin() throws SQLException;

}
