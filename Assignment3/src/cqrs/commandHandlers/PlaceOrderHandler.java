package cqrs.commandHandlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import businessLogic.beans.Order;
import cqrs.commandHandlers.IHandler;
import cqrs.writeModel.ICommand;
import cqrs.writeModel.PlaceOrderCommand;
import dataAccess.connection.ConnectionFactory;

public class PlaceOrderHandler implements IHandler {

	private String type;

	public PlaceOrderHandler() {
		this.type="placeOrder";
	}

	@Override
	public String handle(ICommand placeOrderCommand) {
		Order orderInfo=((PlaceOrderCommand) placeOrderCommand).getOrderInfo();
		String firstName = orderInfo.getFirst_name();
		String lastName = orderInfo.getLast_name();
		String address =orderInfo.getAddress();
		String city = orderInfo.getCity();
		String zipcode =orderInfo.getZipcode();
		String country = orderInfo.getCountry();
		Double total=orderInfo.getTotal();
		String username=orderInfo.getUsername();
		String state=orderInfo.getState();
		String id=orderInfo.getId().toString();

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try
		{
			ConnectionFactory.getInstance();
			con = ConnectionFactory.getConnection();
			String query = "insert into furniture_deals.order (id,first_name,last_name,address,city,zipcode,country,total,username,state,feedback) values (?,?,?,?,?,?,?,?,?,?,NULL)"; 
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, lastName);
			preparedStatement.setString(4, address);
			preparedStatement.setString(5, city);
			preparedStatement.setString(6, zipcode);
			preparedStatement.setString(7, country);
			preparedStatement.setString(8, Double.toString(total));
			preparedStatement.setString(9, username);
			preparedStatement.setString(10, state);

			int i= preparedStatement.executeUpdate();

			if (i!=0)  //Just to ensure data has been inserted into the database
				return "SUCCESS"; 
		}catch(SQLException e){
			e.printStackTrace();
		}

		return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
