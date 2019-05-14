package cqrs.writeModel;

public class UpdateOrderCommand implements ICommand {

	private String orderId;
	private String orderSate;
	private String type;
	
	public UpdateOrderCommand(String id,String state) {
		this.orderId=id;
		this.orderSate=state;
		this.type="updateOrderState";
	}
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderSate() {
		return orderSate;
	}
	public void setOrderSate(String orderSate) {
		this.orderSate = orderSate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
