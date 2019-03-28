package businessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import businessLogic.beans.Order;
import dataAccess.connection.ConnectionFactory;

public class OrderDAO {

	public String placeOrder(Order order){

		String firstName = order.getFirst_name();
		String lastName = order.getLast_name();
		String address = order.getAddress();
		String city = order.getCity();
		String zipcode = order.getZipcode();
		String country = order.getCountry();
		Double total=order.getTotal();

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try
		{
			ConnectionFactory.getInstance();
			con = ConnectionFactory.getConnection();
			String query = "insert into furnituredeals.order (id,first_name,last_name,address,city,zipcode,country,total) values (NULL,?,?,?,?,?,?,?)"; 
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, city);
			preparedStatement.setString(5, zipcode);
			preparedStatement.setString(6, country);
			preparedStatement.setString(7, Double.toString(total));

			int i= preparedStatement.executeUpdate();

			if (i!=0)  //Just to ensure data has been inserted into the database
				return "SUCCESS"; 
		}catch(SQLException e){
			e.printStackTrace();
		}

		return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}
}
