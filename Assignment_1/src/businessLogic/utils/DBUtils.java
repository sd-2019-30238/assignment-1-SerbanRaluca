package businessLogic.utils;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import businessLogic.beans.User;
 
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
 
}
