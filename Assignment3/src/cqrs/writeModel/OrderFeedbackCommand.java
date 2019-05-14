package cqrs.writeModel;

public class OrderFeedbackCommand implements ICommand {

	private String feedback;
	private String orderId;
	private String type;
	
	public OrderFeedbackCommand(String feedback,String id) {
		this.feedback=feedback;
		this.orderId=id;
		this.type="orderFeedback";
	}
	
	public String getType() {
		return this.type;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
