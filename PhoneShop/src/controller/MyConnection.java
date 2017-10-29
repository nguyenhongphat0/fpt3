package controller;


import java.sql.Connection;
import java.sql.DriverManager;
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
public class MyConnection {
    static String username = "sa";
    static String password = "HongPhat0";
    static String dbname = "PHONESHOP";
    static String port = "1433";

    public static Connection getConnection() { // get connection by config info
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:"+ port +";databaseName=" + dbname, username, password);
            return conn;            
        } catch (ClassNotFoundException | SQLException ex) {
//            ex.printStackTrace();
            return null;
        }
        
    }
    
    public static void closeConnection(Connection conn, PreparedStatement pre, ResultSet res) { // close connection
        try {
            if (res != null) res.close();
            if (pre != null) pre.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
//            ex.printStackTrace();
        }
    }
}
