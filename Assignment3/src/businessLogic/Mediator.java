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
	
	public String handle(ICommand command) {
		String type=command.getType();
		String result = null;
		for(IHandler h:handlers) {
			if(h.getType().equals(type)) {
				result=h.handle(command);
			}
		}
		return result;
	}
}
