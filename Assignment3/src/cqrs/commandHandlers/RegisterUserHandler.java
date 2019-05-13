package cqrs.commandHandlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.RegisterDAO;
import businessLogic.beans.User;
import cqrs.writeModel.ICommand;
import cqrs.writeModel.UserRegisterCommand;

public class RegisterUserHandler implements IHandler{

	@Override
	public void handle(ICommand registerUserCommand) {
		User user=((UserRegisterCommand) registerUserCommand).getUser();
		RegisterDAO registerDao=new RegisterDAO();
		String userRegistered=registerDao.registerUser(user);
		HttpServletRequest request=((UserRegisterCommand) registerUserCommand).getRequest();
		HttpServletResponse response=((UserRegisterCommand) registerUserCommand).getResponse();
		if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			try {
				request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else   //On Failure, display a meaningful message to the User.
		{
			request.setAttribute("errMessage", userRegistered);
			try {
				request.getRequestDispatcher("/register1.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
