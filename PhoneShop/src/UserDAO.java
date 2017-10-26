
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhongphat0
 */
public class UserDAO implements Serializable {
    
    public static UserDTO getUser(String username, String password) {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement("SELECT username, password, fullname, roles FROM Users WHERE username = ? AND password = ?");
            pre.setString(1, username);
            pre.setString(2, password);
            res = pre.executeQuery();
            if (res.next()) {
                user = new UserDTO(username, password, res.getString("fullname"), res.getString("roles"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MyConnection.closeConnection(conn, pre, res);
        }
        return user;
        
    }
    
}
