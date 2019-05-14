package cqrs.commandHandlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cqrs.commandHandlers.IHandler;
import cqrs.writeModel.ICommand;
import cqrs.writeModel.UpdateProductPriceCommand;
import dataAccess.connection.ConnectionFactory;

public class UpdateProductPriceHandler implements IHandler {

	private String type;
	
	public UpdateProductPriceHandler() {
		this.type="updatePrice";
	}
	
	
	@Override
	public String handle(ICommand updatePriceCommand) {
		String code= ((UpdateProductPriceCommand) updatePriceCommand).getCode();
		Double price=((UpdateProductPriceCommand) updatePriceCommand).getNewPrice();
		String sql = "UPDATE product SET price=? WHERE code=?";
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			ConnectionFactory.getInstance();
			con=ConnectionFactory.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setDouble(1, price);
			preparedStatement.setString(2, code);

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
