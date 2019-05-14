package cqrs.writeModel;

import businessLogic.Mediator;
import businessLogic.beans.Order;
import cqrs.commandHandlers.IHandler;
import cqrs.commandHandlers.OrderFeedbackHandler;
import cqrs.commandHandlers.PlaceOrderHandler;
import cqrs.commandHandlers.UpdateOrderHandler;

public class OrderWriteModel {

private Mediator mediator;
	
	public OrderWriteModel(Mediator mediator) {
		this.setMediator(mediator);
	}
	
	public String updateFeedback(String feedback,String id)
	{
		ICommand command=new OrderFeedbackCommand(feedback,id);
		IHandler handler=new OrderFeedbackHandler();
		mediator.registerHandler(handler);
		return mediator.handle(command);
	}
	
	public String placeOrder(Order order) {
		ICommand command=new PlaceOrderCommand(order);
		IHandler handler=new PlaceOrderHandler();
		mediator.registerHandler(handler);
		return mediator.handle(command);
	}
	
	public String updateOrder(String id,String state) {
		ICommand command=new UpdateOrderCommand(id,state);
		IHandler handler=new UpdateOrderHandler();
		mediator.registerHandler(handler);
		return mediator.handle(command);
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
}
