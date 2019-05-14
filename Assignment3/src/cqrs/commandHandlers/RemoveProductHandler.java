package cqrs.commandHandlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cqrs.commandHandlers.IHandler;
import cqrs.writeModel.ICommand;
import cqrs.writeModel.RemoveProductCommand;
import dataAccess.connection.ConnectionFactory;

public class RemoveProductHandler implements IHandler {

	private String type;
	
	public RemoveProductHandler() {
		this.type="removeProduct";
	}
	
	
	@Override
	public String handle(ICommand removeProductCommand) {
		String code=((RemoveProductCommand) removeProductCommand).getCode();
		String sql = "DELETE FROM  furniture_deals.product WHERE code=?";
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			ConnectionFactory.getInstance();
			con=ConnectionFactory.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, code);

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
