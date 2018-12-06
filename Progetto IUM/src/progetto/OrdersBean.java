package progetto;

import java.io.Serializable;

public class OrdersBean implements Serializable {
	private static final long serialVersionUID = 1L;
	String code;
	String date;
	String email;
	String total;
	String state;
	String payment;
	String codeClient;

	public OrdersBean() {
		code = "";
		date = "";
		email="";
		codeClient = "";
		payment = "";
		total = "";
		state = "";
	}

	public String getcode() {
		return code;
	}

	public void setcode(String code) {
		this.code = code;
	}


	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}

	public String gettotal() {
		return total;
	}

	public void settotal(String total) {
		this.total = total;
	}

	public String getstate() {
		return state;
	}

	public void setstate(String state) {
		this.state = state;
	}

	public String getpayment() {
		return payment;
	}

	public void setpayment(String payment) {
		this.payment = payment;
	}

	public String getcodeClient() {
		return codeClient;
	}

	public void setcodeClient(String codeClient) {
		this.codeClient = codeClient;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String toString() {
		return "OrdersBean [code=" + code + ", date=" + date + ", total=" + total + ", state="
				+ state + ", payment=" + payment + ", codeClient=" + codeClient + ", code=" + code + "]";
	}
}