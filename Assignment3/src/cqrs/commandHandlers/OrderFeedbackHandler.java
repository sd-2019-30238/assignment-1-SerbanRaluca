package cqrs.commandHandlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import cqrs.writeModel.OrderFeedbackCommand;
import cqrs.commandHandlers.IHandler;
import cqrs.writeModel.ICommand;
import dataAccess.connection.ConnectionFactory;

public class OrderFeedbackHandler implements IHandler {
	
	private String type;

	public OrderFeedbackHandler() {
		this.setType("orderFeedback");
	}


	@Override
	public String handle(ICommand orderFeedbackCommand) {
		String feedback=((OrderFeedbackCommand) orderFeedbackCommand).getFeedback();
		String id=((OrderFeedbackCommand) orderFeedbackCommand).getOrderId();
		
		String sql = "UPDATE furniture_deals.order SET feedback=? WHERE id=?";
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			ConnectionFactory.getInstance();
			con=ConnectionFactory.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, feedback);
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
