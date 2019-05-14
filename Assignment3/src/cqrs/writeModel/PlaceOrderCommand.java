package cqrs.writeModel;

import businessLogic.beans.Order;

public class PlaceOrderCommand implements ICommand {

	private Order orderInfo;
	private String type;
	
	public PlaceOrderCommand(Order order) {
		this.orderInfo=order;
		this.type="placeOrder";
	}


	public Order getOrderInfo() {
		return orderInfo;
	}


	public void setOrderInfo(Order orderInfo) {
		this.orderInfo = orderInfo;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

}
