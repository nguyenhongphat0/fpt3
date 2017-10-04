
import java.io.Serializable;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class AccountDTO implements Serializable {
    String id, name, address;
    int salary;
    boolean isMale;

    public AccountDTO() {
    }

    public AccountDTO(String id, String name, String address, boolean isMale, int salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.isMale = isMale;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isIsMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(id);
        v.add(name);
        v.add(address);
        v.add(isMale);
        v.add(salary);
        return v;
    }
}
