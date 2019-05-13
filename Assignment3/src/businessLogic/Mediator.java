package businessLogic;
import java.util.ArrayList;
import java.util.List;

import cqrs.commandHandlers.*;
import cqrs.writeModel.ICommand;
public class Mediator {

	public List<IHandler> handlers;
	
	public Mediator() {
		handlers=new ArrayList<IHandler>();
	}
	
	public void registerHandler(IHandler handler) {
		handlers.add(handler);
	}
	
	public void handle(String type) {
		for(IHandler h:handlers) {
		}
	}
}
