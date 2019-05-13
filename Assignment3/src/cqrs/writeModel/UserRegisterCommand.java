package cqrs.writeModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.beans.User;

public class UserRegisterCommand implements ICommand {

	private User user;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public UserRegisterCommand(User user,HttpServletRequest request,HttpServletResponse response) {
		this.setUser(user);
		this.setRequest(request);
		this.setResponse(response);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}	
}
