package businessLogic.beans;

import businessLogic.Mediator;
import cqrs.writeModel.OrderWriteModel;

public class OrderObserver implements Observer {

	private OrderWriteModel orderModel;
	public OrderObserver() {
		Mediator mediator=new Mediator();
		orderModel=new OrderWriteModel(mediator);
	}

	@Override
	public void update(String id,String state) {
		orderModel.updateOrder(id,state);
		System.out.println("Updated");
	}
}
