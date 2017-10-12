
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhongphat0
 */
public class UserDAO {
    
    public List<UserDTO> findlike(String name) {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        ResultSet res = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=STUDENT", "sa", "HongPhat0");
            ps = conn.prepareStatement("SELECT * FROM Students WHERE fullname LIKE N'%" + name + "%'");
            res = ps.executeQuery();
            while (res.next()) {
                list.add(new UserDTO(res.getString("username"), res.getString("fullname"), res.getString("password"), res.getString("roles")));
            }
        } catch (Exception e) {
        } finally {
            try {
                if (res != null) res.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return list;        
    }
    
    public boolean insert(UserDTO dto) {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO Students(username, fullname, password, roles) VALUES(?,?,?,?)";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=STUDENT","sa","HongPhat0");
            pre = conn.prepareStatement(sql);
            pre.setString(1, dto.getUsername());
            pre.setString(2, dto.getFullname());
            pre.setString(3, dto.getPassword());
            pre.setString(4, dto.getRole());
            check = pre.executeUpdate() > 0;
            System.out.println("++ insert " + dto.username + " successful");
        } catch (Exception e) {
            System.out.println("!! insert " + dto.username + " failed");
        } finally {
            
        }
        return check;
    }
    
    public boolean delete(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM Students WHERE username=?";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=STUDENT", "sa", "HongPhat0");
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
//        test those function
//
//        UserDAO dao = new UserDAO();
//        dao.insert(new UserDTO("nguyenhongphat0", "Nguyễn Hồng Phát", "hongphat", "ADMIN"));
//        dao.insert(new UserDTO("phungquocviet", "Phùng Quốc Việt", "quocviet", "USER"));
//        dao.delete("nguyenhongphat0");
//        List<UserDTO> list = dao.findlike("Vi");
//        System.out.println("-> found " + list.size() + " result");
//        for (UserDTO user : list) {
//            System.out.println(user);
//        }
    }
    
}
