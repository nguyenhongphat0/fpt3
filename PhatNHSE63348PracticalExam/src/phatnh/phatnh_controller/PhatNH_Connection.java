/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.phatnh_controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nguyenhongphat0
 */
public class PhatNH_Connection {
    
    static String phatnh_username = "sa";
    static String phatnh_password = "HongPhat0";
    static String phatnh_dbname = "PracticalPrj311";
    static String phatnh_port = "1433";

    public static Connection getConnection() { // get connection by config info
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:"+ phatnh_port +";databaseName=" + phatnh_dbname, phatnh_username, phatnh_password);
            return conn;            
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        
    }
    
    public static void closeConnection(Connection conn, PreparedStatement pre, ResultSet res) { // close connection
        try {
            if (res != null) res.close();
            if (pre != null) pre.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
