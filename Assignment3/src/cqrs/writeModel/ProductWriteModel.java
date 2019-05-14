package cqrs.writeModel;

import businessLogic.Mediator;
import businessLogic.beans.Product;
import cqrs.commandHandlers.AddProductHandler;
import cqrs.commandHandlers.IHandler;
import cqrs.commandHandlers.RemoveProductHandler;
import cqrs.commandHandlers.UpdateProductPriceHandler;

public class ProductWriteModel {
	
private Mediator mediator;
	
	public ProductWriteModel(Mediator mediator) {
		this.setMediator(mediator);
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	
	public String addProduct(Product product) {
		ICommand command=new AddProductCommand(product);
		IHandler handler=new AddProductHandler();
		mediator.registerHandler(handler);
		return mediator.handle(command);
	}
	
	public String updateProduct(String code,int quantity) {
		ICommand command=new UpdateProductCommand(code,quantity);
		IHandler handler=new UpdateProductHandler();
		mediator.registerHandler(handler);
		return mediator.handle(command);
	}
	
	public String updatePrice(String code,Double price) {
		ICommand command=new UpdateProductPriceCommand(code,price);
		IHandler handler=new UpdateProductPriceHandler();
		mediator.registerHandler(handler);
		return mediator.handle(command);
	}
	
	public String removeProduct(String code) {
		ICommand command=new RemoveProductCommand(code);
		IHandler handler=new RemoveProductHandler();
		mediator.registerHandler(handler);
		return mediator.handle(command);
	}

}
