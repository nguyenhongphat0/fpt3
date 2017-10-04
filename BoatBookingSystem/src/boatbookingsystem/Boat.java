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
public class Boat implements Comparable {
    String bcode, boatName, departPlace;
    int seat, booked;
    double rate;

    public Boat() {
    }

    public Boat(String code, String name, String departPlace, int seat, int booked, double rate) {
        this.bcode = code;
        this.boatName = name;
        this.departPlace = departPlace;
        this.seat = seat;
        this.booked = booked;
        this.rate = rate;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getBoatName() {
        return boatName;
    }

    public void setBoatName(String boatName) {
        this.boatName = boatName;
    }

    public String getDepartPlace() {
        return departPlace;
    }

    public void setDepartPlace(String departPlace) {
        this.departPlace = departPlace;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public int compareTo(Object o) {
        return this.bcode.compareTo(((Boat)o).bcode);
    }

    @Override
    public String toString() {
        return String.format("%-6s%-15s%-8d%-8d%-15s%-10.2f%-15d", bcode, boatName, seat, booked, departPlace, rate, seat-booked);
    }
}
