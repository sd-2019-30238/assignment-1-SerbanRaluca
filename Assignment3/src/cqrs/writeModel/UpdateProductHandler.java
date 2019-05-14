package cqrs.writeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cqrs.commandHandlers.IHandler;
import dataAccess.connection.ConnectionFactory;

public class UpdateProductHandler implements IHandler {
	
	private String type;

	public UpdateProductHandler() {
		this.setType("updateProduct");
	}

	@Override
	public String handle(ICommand updateProductCommand) {
		String code=((UpdateProductCommand) updateProductCommand).getCode();
		int quantity=((UpdateProductCommand) updateProductCommand).getQuantity();
		String sql = "UPDATE product SET quantity=? WHERE code=?";
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			ConnectionFactory.getInstance();
			con=ConnectionFactory.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, quantity);
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
