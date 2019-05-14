/**
 * 
 */
package cqrs.writeModel;

public class UpdateProductCommand implements ICommand {

	private String code;
	private int quantity;
	private String type;
	
	public UpdateProductCommand(String code,int quantity) {
		this.setCode(code);
		this.setQuantity(quantity);
		this.type="updateProduct";
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
