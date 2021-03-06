/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class Department {
    private String code, name;

    public Department() {
    }

    public Department(String code, String name) {
        this.code = code;
        if (name.endsWith(":")) {
            name = name.substring(0, name.length()-1);
        }
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return code + "-" + name;
    }
    
}
