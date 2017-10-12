
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

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

    /**
     * @param args the command line arguments
     */
    
    static Connection openConnection() {
        String ip = "localhost";
        String db = "Student";
        String uid = "sa";
        String password = "HongPhat0";
        String port = "1433";
        Connection c = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://" + ip + ":" + port + ";databaseName=" + db + ";user=" + uid + ";password=" + password;
        try {
            Class.forName(driver);
            c = DriverManager.getConnection(url);
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return c;
    }
    
    public static class Student {
        public String username, fullname, password, roles;

        public Student() {
        }

        public Student(String username, String fullname, String password, String roles) {
            this.username = username;
            this.fullname = fullname;
            this.password = password;
            this.roles = roles;
        }
        
        public Student(String s) {
            String[] data = s.split(" \\| ");
            this.username = data[0];
            this.fullname = data[1];
            this.password = data[2];
            this.roles = data[3];
        }
    }
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Connection conn = openConnection();
        ResultSet res = conn.prepareStatement("SELECT * FROM Students").executeQuery();
        ArrayList<Student> list = new ArrayList<>();
        while (res.next()) {            
            list.add(new Student(res.getString("username") + " | " + res.getString("fullname") + " | " + res.getString("password") + " | " + res.getString("roles")));
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Student code: ");
        String code = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        boolean ck = false;
        for (Student student : list) {
            if (student.username.equals(code) && student.password.equals(pass)) {
                System.out.println("Welcome " + student.fullname);
                ck = true;
            }
        }
        if (ck == false) {
            System.out.println("Invalid cridential");
        }
    }
    
}
