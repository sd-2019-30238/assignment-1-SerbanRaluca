package businessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import businessLogic.beans.Product;
import dataAccess.connection.ConnectionFactory;

public class ProductDAO {

	public String insertProduct(Product product) {
		String code = product.getCode();
		String name=product.getName();
		String photo=product.getPhoto();
		Double price=product.getPrice();
		String category=product.getCategory();
		int quantity=product.getQuantity();

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try
		{
			ConnectionFactory.getInstance();
			con = ConnectionFactory.getConnection();
			String query = "insert into furnituredeals.product (code,name,photo,price,category,quantity) values (?,?,?,?,?,?)"; 
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, code);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, photo);
			preparedStatement.setDouble(4, price);
			preparedStatement.setString(5, category);
			preparedStatement.setInt(6, quantity);

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

}
