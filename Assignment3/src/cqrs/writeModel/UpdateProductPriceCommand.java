package cqrs.writeModel;

public class UpdateProductPriceCommand implements ICommand {

	private String code;
	private Double newPrice;
	private String type;
	
	
	public UpdateProductPriceCommand(String code,Double price) {
		this.code=code;
		this.newPrice=price;
		this.type="updatePrice";
	}
	

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Double getNewPrice() {
		return newPrice;
	}


	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

}
