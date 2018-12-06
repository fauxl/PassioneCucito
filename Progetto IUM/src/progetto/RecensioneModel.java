package progetto;

import java.sql.SQLException;
import java.util.Collection;

public interface RecensioneModel {

	public Collection<RecensioneBean> doRetrieveAll(String code) throws SQLException;
	
	public Collection<RecensioneBean> doRetrieveAllArea(String email) throws SQLException;

	public String Getemail(String email);
	
	public void doSaveRev(RecensioneBean Recensione) throws SQLException;

	public boolean doDeleteReview(String code) throws SQLException;

	
}
