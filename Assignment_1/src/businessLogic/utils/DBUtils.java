package businessLogic.utils;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 
        String sql = "Select username, password  from user "//
                + " where username = ? ";
 
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
        String sql = "Select code, name,photo, price from product ";
        ConnectionFactory.getInstance();
		Connection conn=ConnectionFactory.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            String code = rs.getString("code");
            String name = rs.getString("name");
            String photo = rs.getString("photo");
            float price = rs.getFloat("price");
            Product product = new Product();
            product.setCode(code);
            product.setName(name);
            product.setPhoto(photo);
            product.setPrice(price);
            list.add(product);
        }
        return list;
    }
    
    public static Product findProduct(String code) throws SQLException {
        String sql = "Select code, name,photo, price from Product a where code=?";
        ConnectionFactory.getInstance();
		Connection conn=ConnectionFactory.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            String name = rs.getString("name");
            String photo = rs.getString("photo");
            float price = rs.getFloat("price");
            Product product = new Product(code, name,photo, price);
            return product;
        }
        return null;
    }
    
}
