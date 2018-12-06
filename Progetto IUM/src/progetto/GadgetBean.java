package progetto;

import java.io.Serializable;

public class GadgetBean implements Serializable {
	private static final long serialVersionUID = 1L;

	String code;
	String category;
	float price;
	String dimension;
	String type;
	String name;
	String image;
	String publisher;
	String description;
	int quantity;
	int availability;


	public GadgetBean() {
		code = "";
		category = "";
		type = "";
		price = 0;
		dimension = "";
		name = "";
		image = "";
		publisher = "";
		quantity=1;
		availability=1;
		}
		
		public int getavailability() {
			return	availability;
		}

		public void setavailability(int availability) {
			this.availability = availability;
		}
		
	public String getcode() {
		return code;
	}

	public void setcode(String code) {
		this.code = code;
	}

	public int getquantity() {
		return quantity;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getpublisher() {
		return publisher;
	}

	public void setpublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public String getcategory() {
		return category;
	}

	public void setcategory(String category) {
		this.category = category;
	}

	public float getprice() {
		return price;
	}

	public void setprice(float price) {
		this.price = price;
	}

	public String getdimension() {
		return dimension;
	}

	
	
	public void setdimension(String dimension) {
		this.dimension = dimension;
	}

	public String gettype() {
		return type;
	}

	public void settype(String type) {
		this.type = type;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getimage() {
		return image;
	}

	public void setimage(String image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return "GadgetBean [code=" + code + ", category=" + category + ", price=" + price + ", dimension="
				+ dimension + ", type=" + type + ", name=" + name + ", description=" + description + "]";
	}
}