package progetto;

import java.sql.SQLException;
import java.util.Collection;

import progetto.ClientBean;

public interface ClientModel {
	public void doSave(ClientBean Client) throws SQLException;
	
	public boolean doDelete(String code) throws SQLException;
	public Collection<ClientBean> doRetrieveAll() throws SQLException;
	public ClientBean getClient(String email) throws SQLException;
	
	public void doUpdate(ClientBean Client, String email) throws SQLException;

	public String Check(String email) throws SQLException;

}