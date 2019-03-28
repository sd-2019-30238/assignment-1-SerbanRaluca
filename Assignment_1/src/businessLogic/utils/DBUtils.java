package businessLogic.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import businessLogic.beans.Order;
import businessLogic.beans.Product;
import businessLogic.beans.User;
import dataAccess.connection.ConnectionFactory;

public class DBUtils {

	public static User findUser(Connection conn, String userName, String password) throws SQLException {

		String sql = "Select username, password  from user " 
				+ " where username = ? and password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			return user;
		}
		return null;
	}

	public static User findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select username, password  from user  where username = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			return user;
		}
		return null;
	}

	public static List<Product> queryProduct() throws SQLException {
		String sql = "Select code, name,photo, price,category,quantity from product ";
		ConnectionFactory.getInstance();
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String code = rs.getString("code");
			String name = rs.getString("name");
			String photo = rs.getString("photo");
			String category= rs.getString("category");
			int quantity = rs.getInt("quantity");
			float price = rs.getFloat("price");
			Product product = new Product();
			product.setCode(code);
			product.setName(name);
			product.setPhoto(photo);
			product.setPrice(price);
			product.setCategory(category);
			product.setQuantity(quantity);
			list.add(product);
		}
		return list;
	}

	public static Product findProduct(String code) throws SQLException {
		String sql = "Select code, name,photo, price,category,quantity from product  where code=?";
		ConnectionFactory.getInstance();
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("name");
			String photo = rs.getString("photo");
			float price = rs.getFloat("price");
			String category= rs.getString("category");
			int quantity = rs.getInt("quantity");
			Product product = new Product(code, name,photo, price,category,quantity);
			return product;
		}
		return null;
	}
	
	public static List<Product> findByName(String name) throws SQLException {
		String sql = "Select code, name,photo, price,category,quantity from product  where name=?";
		ConnectionFactory.getInstance();
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, name);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String code = rs.getString("code");
			String photo = rs.getString("photo");
			float price = rs.getFloat("price");
			String category= rs.getString("category");
			int quantity = rs.getInt("quantity");
			Product product = new Product();
			product.setCode(code);
			product.setName(name);
			product.setPhoto(photo);
			product.setPrice(price);
			product.setCategory(category);
			product.setQuantity(quantity);
			list.add(product);
			
		}
		return list;
	}

	public static String updateProduct(String code,int quantity) throws SQLException {
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


	public static List<Product> queryCategory(String category) throws SQLException {
		String sql = "Select code, name,photo, price,category,quantity from product where category=? ";
		ConnectionFactory.getInstance();
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, category);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String code = rs.getString("code");
			String name = rs.getString("name");
			String photo = rs.getString("photo");
			int quantity = rs.getInt("quantity");
			float price = rs.getFloat("price");
			Product product = new Product();
			product.setCode(code);
			product.setName(name);
			product.setPhoto(photo);
			product.setPrice(price);
			product.setCategory(category);
			product.setQuantity(quantity);
			list.add(product);
		}
		return list;
	}

	public static List<Product> queryPrice(double min,double max) throws SQLException {
		String sql = "Select code, name,photo, price,category,quantity from product where price > ? and price < ? ";
		ConnectionFactory.getInstance();
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setDouble(1, min);
		pstm.setDouble(2, max);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String code = rs.getString("code");
			String name = rs.getString("name");
			String photo = rs.getString("photo");
			String category = rs.getString("category");
			int quantity = rs.getInt("quantity");
			double price = rs.getDouble("price");
			Product product = new Product();
			product.setCode(code);
			product.setName(name);
			product.setPhoto(photo);
			product.setPrice(price);
			product.setCategory(category);
			product.setQuantity(quantity);
			list.add(product);
		}
		return list;
	} 
	
	public static List<Order> queryOrder(String username) throws SQLException {
		String sql = "Select first_name, last_name,address,city, zipcode,country,total,state from furnituredeals.order where username=? ";
		ConnectionFactory.getInstance();
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);

		ResultSet rs = pstm.executeQuery();
		List<Order> list = new ArrayList<Order>();
		while (rs.next()) {
			String firstname = rs.getString("first_name");
			String lastname = rs.getString("last_name");
			String address = rs.getString("address");
			String city = rs.getString("city");
			String country = rs.getString("country");
			String zipcode = rs.getString("zipcode");
			Double total=rs.getDouble("total");
			String state=rs.getString("state");
			Order order = new Order();
			order.setFirst_name(firstname);
			order.setAddress(address);
			order.setCity(city);
			order.setCountry(country);
			order.setLast_name(lastname);
			order.setState(state);
			order.setTotal(total);
			order.setUsername(username);
			order.setZipcode(zipcode);
			list.add(order);
		}
		return list;
	}


}
