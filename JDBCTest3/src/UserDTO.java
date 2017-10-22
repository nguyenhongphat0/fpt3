
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
    String username, fullname, password, roles;

    public UserDTO() {
    }

    public UserDTO(String username, String fullname, String password, String roles) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.roles = roles;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "username=" + username + ", fullname=" + fullname + ", password=" + password + ", roles=" + roles + '}';
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(this.username);
        v.add(this.fullname);
        v.add(this.roles);
        return v;
    }
    
}
