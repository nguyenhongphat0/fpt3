/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salemanagementsystem;

/**
 *
 * @author DuongPTH
 */
public class Customer implements Comparable<Customer> {

    private String cCode;
    private String cName;
    private String phone;

    public Customer(String cCode, String cName, String phone) {
        this.cCode = cCode;
        this.cName = cName;
        this.phone = phone;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(Customer that) {
        return this.getcCode().compareTo(that.getcCode());
    }

    @Override
    public String toString() {
        return String.format("%5s|%15s|%15s\n", cCode, cName, phone);
    }

}
