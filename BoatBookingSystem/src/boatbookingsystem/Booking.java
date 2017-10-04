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
public class Booking implements Comparable {
    String bcode, ccode;
    int seat;

    public Booking() {
    }

    public Booking(String boatCode, String customerCode, int seat) {
        this.bcode = boatCode;
        this.ccode = customerCode;
        this.seat = seat;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public int compareTo(Object o) {
        return (bcode+ccode).compareTo(((Booking)o).bcode+((Booking)o).ccode);
    }

    @Override
    public String toString() {
        int pos = Main.bm.bl.search(bcode);
        if (pos == -1) return "This booking record is expired because the boat is not existing anymore";
        Boat b = Main.bm.bl.list.get(pos);
        return String.format("%-8s%-8s%-15d%-15d", bcode, ccode, seat, b.seat-b.booked);
    }
}
