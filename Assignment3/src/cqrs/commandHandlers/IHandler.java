package cqrs.commandHandlers;

import cqrs.writeModel.ICommand;

public interface IHandler {

	public void handle(ICommand command);
}
