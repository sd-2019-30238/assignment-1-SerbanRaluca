package cqrs.writeModel;

import businessLogic.beans.Product;

public class AddProductCommand implements ICommand {
	
	private Product productinfo;
	private String type;
	
	public AddProductCommand(Product product) {
		this.setProductinfo(product);
		this.setType("addProduct");
	}

	public Product getProductInfo() {
		return productinfo;
	}

	public void setProductinfo(Product productinfo) {
		this.productinfo = productinfo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
