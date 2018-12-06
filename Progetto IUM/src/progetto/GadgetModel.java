package progetto;

import java.sql.SQLException;
import java.util.Collection;

import progetto.GadgetBean;

public interface GadgetModel {
	
	
	public Collection<GadgetBean> doRetrieveAll(String sort) throws SQLException;
	public Collection<GadgetBean> doRetrieveAll() throws SQLException;
	public Collection<GadgetBean> doRetrieveAllG(String code) throws SQLException;
	public Collection<GadgetBean> doRetrieveAllOrders(String code) throws SQLException;
	public GadgetBean doRetrieveByKey(String code) throws SQLException;

	public boolean doDeleteGadget(String code, String email) throws SQLException;
	public boolean doDelete(String code,String email) throws SQLException;
	
	public boolean doAddGadget(String code,String email)throws SQLException;

	
	public void doSaveG(GadgetBean Gadget) throws SQLException;
	
	
	public void doUpdateG(GadgetBean Gadget, String codgadget) throws SQLException;
	
	public boolean doDeleteGadget(String code) throws SQLException;
	public boolean doDelete(String code) throws SQLException;

	public Collection<GadgetBean> doRetrieveAllG() throws SQLException;
	public void Shopgadget(String gadget, String order, int quantity,int availability)throws SQLException;


	public String Getemail(String email);
	public String verifica();
	public String verifica2();
	
	public GadgetBean doRetrieveByKey3(String code) throws SQLException;
	public Collection<GadgetBean> doRetrieveAll3(String order) throws SQLException;
	
	public Collection<GadgetBean> doRetrieveAll2(String search) throws SQLException;

		public Collection<GadgetBean> doRetrieveAll(String tipo,String  publisher, String sort) throws SQLException;
}