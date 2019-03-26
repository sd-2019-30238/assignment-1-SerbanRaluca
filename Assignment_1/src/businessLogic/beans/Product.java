package businessLogic.beans;

public class Product {

	private String code;
	private String name;
	private String photo;
	private double price;
	private String category;
	private int quantity;

	public Product(String code, String name, String photo,double price,String category,int quantity) {
		this.code = code;
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.category=category;
		this.quantity=quantity;
	}

	public Product() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
