package cqrs.writeModel;

import businessLogic.beans.Product;

public class AddProductCommand implements ICommand {
	
	private Product productInfo;
	private String type;
	
	public AddProductCommand(Product product) {
		this.setProductinfo(product);
		this.setType("addProduct");
	}

	public Product getProductInfo() {
		return productInfo;
	}

	public void setProductinfo(Product productInfo) {
		this.productInfo = productInfo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
