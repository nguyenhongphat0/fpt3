/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boatbookingsystem;

/**
 *
 * @author Phat
 */
public class Customer implements Comparable {
    String ccode, customerName, phone;

    public Customer() {
    }

    public Customer(String code, String name, String phone) {
        this.ccode = code;
        this.customerName = name;
        this.phone = phone;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(Object o) {
        return ccode.compareTo(((Customer)o).ccode);
    }
    
    @Override
    public String toString() {
        return String.format("%-6s%-15s%-15s", ccode, customerName, phone);
    }
}
