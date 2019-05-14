package cqrs.readModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import businessLogic.beans.User;
import dataAccess.connection.ConnectionFactory;

public class UserQueryService {

	public static LoginCheckQueryResult loginCheck(String username,String password) {
		ConnectionFactory.getInstance();
		Connection conn=ConnectionFactory.getConnection();
		String sqlQuery="SELECT * FROM user WHERE username=? and password=?";
		PreparedStatement statement;
		String userRole=null;
		LoginCheckQueryResult result;
		try {
			statement = conn.prepareStatement(sqlQuery);
			statement.setString(1,username);
			statement.setString(2,password);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String uname=rs.getString("username");
				String pass=rs.getString("password");
				String role=rs.getString("role");
				if(uname.equals(username) && pass.equals(password) && role.equals("Admin"))
					userRole="Admin_Role";
				else if(uname.equals(username) && password.equals(password) && role.equals("User"))
					userRole="User_Role";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userRole!=null) {
			result=new LoginCheckQueryResult(userRole);
		}else {
			result=new LoginCheckQueryResult("Invalid user credentials!");
		}
		return result;
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
}
