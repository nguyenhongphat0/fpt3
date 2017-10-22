
import java.sql.Connection;
import java.sql.DriverManager;

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
    public static Connection getConnection() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=STUDENT","sa","HongPhat0");
        return conn;        
    }
    
    
}
