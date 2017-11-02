package model.users;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhongphat0
 */
public class UserDTO implements Serializable {
    public String username, password, fullname, roles, passhint, avatar;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String fullname, String roles, String hint, String avatar) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.roles = roles;
        this.passhint = hint;
        this.avatar = avatar;
    }    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Password: " + password + " | Fullname: " + fullname + " | Password hint: " + passhint;
    }

    public String getPasshint() {
        return passhint;
    }

    public void setPasshint(String passhint) {
        this.passhint = passhint;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
}
