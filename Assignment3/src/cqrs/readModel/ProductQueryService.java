package cqrs.readModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import businessLogic.beans.Product;
import dataAccess.connection.ConnectionFactory;

public class ProductQueryService {
	
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
			product.setPrice(Math.round(price));
			product.setCategory(category);
			product.setQuantity(quantity);
			list.add(product);
		}
		return list;
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



}
