package cqrs.commandHandlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import businessLogic.beans.User;
import cqrs.writeModel.ICommand;
import cqrs.writeModel.UserRegisterCommand;
import dataAccess.connection.ConnectionFactory;

public class RegisterUserHandler implements IHandler{

	private String type;

	public RegisterUserHandler() {
		this.type="registerUser";
	}


	@Override
	public String handle(ICommand registerUserCommand) {
		User user=((UserRegisterCommand) registerUserCommand).getUser();
		String firstName = user.getFirst_name();
		String lastName = user.getLast_name();
		String email = user.getEmail();
		String userName = user.getUserName();
		String password = user.getPassword();
		String address = user.getAddress();
		String number = user.getNumber();

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try
		{
			ConnectionFactory.getInstance();
			con = ConnectionFactory.getConnection();
			String query = "insert into user (first_name,last_name,email,username,password,address,number,role) values (?,?,?,?,?,?,?,?)"; 
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, userName);
			preparedStatement.setString(5, password);
			preparedStatement.setString(6, address);
			preparedStatement.setString(7, number);
			preparedStatement.setString(8, "User");

			int i= preparedStatement.executeUpdate();

			if (i!=0)  //Just to ensure data has been inserted into the database
				return "SUCCESS"; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}


	public String getType() {
		return type;
	}

}
