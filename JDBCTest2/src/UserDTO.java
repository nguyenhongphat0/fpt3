
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhongphat0
 */
public class UserDTO {
    String username;
    String fullname;
    String password;
    String role;

    public UserDTO() {
    }

    public UserDTO(String username, String fullname, String password, String role) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(username);
        v.add(fullname);
        v.add(password);
        v.add(role);
        return v;
    }
    
    @Override
    public String toString() {
        return "UserDTO{" + "username=" + username + ", fullname=" + fullname + ", password=" + password + ", role=" + role + '}';
    }
}
