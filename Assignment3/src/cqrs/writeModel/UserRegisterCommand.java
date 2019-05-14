package cqrs.writeModel;

import businessLogic.beans.User;

public class UserRegisterCommand implements ICommand {

	private User user;
	private String type;
	
	public UserRegisterCommand(User user) {
		this.setUser(user);
		this.type="registerUser";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	
}
