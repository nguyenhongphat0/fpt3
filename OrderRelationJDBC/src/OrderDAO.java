
import java.sql.Connection;
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
public class OrderDAO {
    private ResultSet rs;
    private Connection conn;
    private PreparedStatement pre;

    public OrderDAO() {
    }
    
    private void closeConnection() {
        try {
            rs.close();
            conn.close();
            pre.close();    
        } catch (Exception e) {
        }
    }
    
    public OrderDTO findByPK(String key) {
        OrderDTO o = null;
        try {
            String sql = "SELECT * FROM Orders WHERE orderid = ?";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, key);
            rs = pre.executeQuery();
            if (rs.next()) {
                o = new OrderDTO(rs.getString("orderid"), rs.getString("userid"), rs.getString("status"), rs.getFloat("total"), rs.getTimestamp("datecreate"));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return o;
    }
    
    public List<OrderDetailDTO> getDetailByOrderID(String orderid) {
        List<OrderDetailDTO> list = new ArrayList<>();
        try {
            String sql = "SELECT productid, quantity, price FROM OrderDetails WHERE orderid = ?";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, orderid);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetailDTO(null, rs.getString("productid"), rs.getInt("quantity"), rs.getFloat("price")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
        
    }
}
