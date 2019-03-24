package businessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import businessLogic.beans.User;
import dataAccess.connection.ConnectionFactory;

public class LoginDAO {

	
	public LoginDAO() {
		
	}
	
	public String LoginCheck(User user) {
		ConnectionFactory.getInstance();
		Connection conn=ConnectionFactory.getConnection();
		String username=user.getUserName();
		String password=user.getPassword();
		String sqlQuery="SELECT * FROM user WHERE username=? and password=?";
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sqlQuery);
			statement.setString(1,username);
			statement.setString(2,password);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String uname=rs.getString("username");
				String pass=rs.getString("password");
				if(uname.equalsIgnoreCase(username) && pass.equalsIgnoreCase(password)) {
					return "success";
				}
				//return "error";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
			
	}
}
