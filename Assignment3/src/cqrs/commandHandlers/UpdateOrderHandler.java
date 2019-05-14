package cqrs.commandHandlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cqrs.commandHandlers.IHandler;
import cqrs.writeModel.UpdateOrderCommand;
import cqrs.writeModel.ICommand;
import dataAccess.connection.ConnectionFactory;

public class UpdateOrderHandler implements IHandler {

	private String type;
	
	public UpdateOrderHandler() {
		this.setType("updateOrderState");
	}
	
	
	@Override
	public String handle(ICommand updateOrderCommand) {
		String state=((UpdateOrderCommand) updateOrderCommand).getOrderSate();
		String id=((UpdateOrderCommand) updateOrderCommand).getOrderId();
		String sql = "UPDATE furniture_deals.order SET state=? WHERE id=?";
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			ConnectionFactory.getInstance();
			con=ConnectionFactory.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, state);
			preparedStatement.setString(2, id);

			int i= preparedStatement.executeUpdate();

			if (i!=0)  //Just to ensure data has been inserted into the database
				return "SUCCESS"; 
		}catch(SQLException e){
			e.printStackTrace();
		}

		return "Oops.. Something went wrong there..!";
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	

}
