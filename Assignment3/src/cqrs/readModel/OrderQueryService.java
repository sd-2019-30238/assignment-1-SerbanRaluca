package cqrs.readModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import businessLogic.beans.Order;
import dataAccess.connection.ConnectionFactory;

public class OrderQueryService {
	
	public static List<Order> queryOrder(String username) throws SQLException {
		String sql = "Select id,first_name, last_name,address,city, zipcode,country,total,state from furniture_deals.order where username=? ";
		ConnectionFactory.getInstance();
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);

		ResultSet rs = pstm.executeQuery();
		List<Order> list = new ArrayList<Order>();
		while (rs.next()) {
			String id=rs.getString("id");
			String firstname = rs.getString("first_name");
			String lastname = rs.getString("last_name");
			String address = rs.getString("address");
			String city = rs.getString("city");
			String country = rs.getString("country");
			String zipcode = rs.getString("zipcode");
			Double total=rs.getDouble("total");
			String state=rs.getString("state");
			Order order = new Order();
			order.setId(UUID.fromString(id));
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
	
	public static List<Order> selectOrders() throws SQLException {
		String sql = "Select id,first_name, last_name,address,city, zipcode,country,total,username,state from furniture_deals.order ";
		ConnectionFactory.getInstance();
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Order> list = new ArrayList<Order>();
		while (rs.next()) {
			String id=rs.getString("id");
			String firstname = rs.getString("first_name");
			String lastname = rs.getString("last_name");
			String address = rs.getString("address");
			String city = rs.getString("city");
			String country = rs.getString("country");
			String zipcode = rs.getString("zipcode");
			String username=rs.getString("username");
			Double total=rs.getDouble("total");
			String state=rs.getString("state");
			Order order = new Order();
			order.setId(UUID.fromString(id));
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
