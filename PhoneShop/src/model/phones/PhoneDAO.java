package model.phones;

import controller.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhongphat0
 */
public class PhoneDAO implements Serializable {
    
    public static ArrayList<PhoneDTO> getAllPhones() { // get all phones from db
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        ArrayList<PhoneDTO> list = new ArrayList<>();
        try {
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement("SELECT id, name, price FROM Phones");
            res = pre.executeQuery();
            while (res.next()) {
                list.add(new PhoneDTO(res.getString("id"), res.getString("name"), null, null, null, res.getFloat("price")));
            }
        } catch (SQLException ex) {
//            ex.printStackTrace();
        } finally {
            MyConnection.closeConnection(conn, pre, res);
        }
        return list;
    }
    
    public static PhoneDTO getPhone(String id) { // get phone by id
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        PhoneDTO phone = null;
        try {
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement("SELECT id, name, os, description, picture, price FROM Phones WHERE id = ?");
            pre.setString(1, id);
            res = pre.executeQuery();
            if (res.next()) {
                phone = new PhoneDTO(res.getString("id"), res.getString("name"), res.getString("os"), res.getString("description"), res.getString("picture"), res.getFloat("price"));
            }
        } catch (Exception e) {
//            e.printStackTrace();
        } finally {
            MyConnection.closeConnection(conn, pre, res);
        }
        return phone;
    }
    
    public static ArrayList<PhoneDTO> findLikeName(String name) { // find phone like name
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        ArrayList<PhoneDTO> list = new ArrayList<>();
        try {
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement("SELECT id, name, price FROM Phones WHERE UPPER(name) LIKE UPPER(?)");
            pre.setString(1, "%" + name.replace(' ', '%') + "%");
            res = pre.executeQuery();
            while (res.next()) {
                list.add(new PhoneDTO(res.getString("id"), res.getString("name"), null, null, null, res.getFloat("price")));
            }
        } catch (SQLException ex) {
//            ex.printStackTrace();
        } finally {
            MyConnection.closeConnection(conn, pre, res);
        }
        return list;
    }
    
    public static boolean addPhone(PhoneDTO phone) { // add new phone
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        boolean c = true;
        try {
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement("INSERT INTO Phones (id, name, os, description, picture, price) VALUES (?, ?, ?, ?, ?, ?)");
            pre.setString(1, phone.id);
            pre.setString(2, phone.name);
            pre.setString(3, phone.os);
            pre.setString(4, phone.description);
            pre.setString(5, phone.picture);
            pre.setFloat(6, phone.price);
            c = pre.executeUpdate() > 0;
        } catch (Exception e) {
//            e.printStackTrace();
            c = false;
        } finally {
            MyConnection.closeConnection(conn, pre, res);
        }
        return c;
    }
    
    public static boolean updatePhone(PhoneDTO phone) { // update phone info
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        boolean c = true;
        try {
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement("UPDATE Phones SET name = ?, os = ?, description = ?, picture = ?, price = ? WHERE id = ?");
            pre.setString(1, phone.name);
            pre.setString(2, phone.os);
            pre.setString(3, phone.description);
            pre.setString(4, phone.picture);
            pre.setFloat(5, phone.price);
            pre.setString(6, phone.id);
            c = pre.executeUpdate() > 0;
        } catch (Exception e) {
//            e.printStackTrace();
            c = false;
        } finally {
            MyConnection.closeConnection(conn, pre, res);
        }
        return c;
    }
    
    public static boolean deletePhone(String id) { // delete phone by id
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        boolean c = true;
        try {
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement("DELETE FROM Phones WHERE id = ?");
            pre.setString(1, id);
            c = pre.executeUpdate() > 0;
        } catch (Exception e) {
//            e.printStackTrace();
            c = false;
        } finally {
            MyConnection.closeConnection(conn, pre, res);
        }
        return c;
    }
}
