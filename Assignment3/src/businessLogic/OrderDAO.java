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
		String username=order.getUsername();
		String state=order.getState();
		String id=order.getId().toString();

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
}
