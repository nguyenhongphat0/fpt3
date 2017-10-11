
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhongphat0
 */
public class Main {

    static List<UserDTO> findByLikeFullname(String search) {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<UserDTO> result = new ArrayList<>();
        try {
            String sql = "SELECT Username, Fullname, Role "
                        + "FROM RegistrationFU "
                        + "WHERE Fullname LIKE ?";
            Class.forName("");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost");
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search +"%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String username = rs.getString("Username");
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Role");
                UserDTO dto = new UserDTO(username, fullname, role);
                result.add(dto);
            }
            
        } catch (Exception e) {
            
            
        } finally {
            
        }
        return result;
    }
    
    static boolean insert(UserDTO dto) {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO RegistrationFU(Username, Password, Fullname, Role) VALUES(?,?,?,?)";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://locahost:1433;databaseName=Sinhvien","sa","HongPhat0");
            pre = conn.prepareStatement(sql);
            pre.setString(1, dto.getUsername());
            pre.setString(2, dto.getFullname());
            //...
//            rs = pre.executeQuery();
//            check = true;
            check = pre.executeUpdate() > 0;
            
        } catch (Exception e) {
        } finally {
            
        }
        return check;
    }
    
    static boolean delete(String id) {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            String sql = "DELETE FROM RegistrationFU "
                    + "WHERE Username = ?";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433");
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            check = pre.executeUpdate() > 0;
            
        } catch (Exception e) {
        } finally {
            
        }
        return check;
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<UserDTO> list = findByLikeFullname("Phat");
        for (UserDTO userDTO : list) {
            System.out.println(userDTO);
        }
        
        
    }
    
}
