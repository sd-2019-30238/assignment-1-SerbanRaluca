package cqrs.writeModel;

import businessLogic.Mediator;
import businessLogic.beans.User;
import cqrs.commandHandlers.IHandler;
import cqrs.commandHandlers.RegisterUserHandler;

public class UserWriteModel {
	
	private Mediator mediator;
	
	public UserWriteModel(Mediator mediator) {
		this.mediator=mediator;
	}

	public String registerUser(User user)
	{
		ICommand command=new UserRegisterCommand(user);
		IHandler handler=new RegisterUserHandler();
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
