/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boatbookingsystem;

import java.awt.print.Book;

/**
 *
 * @author Phat
 */
public class BookingList {
    public MyLinkedList<Booking> list = new MyLinkedList<>();

    public BookingList() {
    }
    
    public Booking newBooking() {
        Boat b = null;
        String bcode, ccode;
        int res, maxSeat = 1;
        bcode = Reader.readAString("Enter boat code: ", ".+");
        res = Main.bm.bl.search(bcode);
        if (res == -1) {
            System.out.println("This boat is not exist, try again");
            return null;
        }
        else {
            b = Main.bm.bl.list.get(res);
            if (b.seat <= b.booked) {
                System.out.println("Sorry! This boat is exhausted. Try another boat");
                return null;
            }
            else maxSeat = b.seat - b.booked;
        }
        ccode = Reader.readAString("Enter customer code: ", ".+");
        res = Main.cm.cl.search(ccode);
        if (res == -1) {
            System.out.println("This customer is not exist, try again");
            return null;
        }
        if (exist(bcode, ccode)) {
            System.out.println("Both boat code and customer code are found in the booking list. Try again");
            return null;
        }
        int seat = Reader.readANumber("Number of seats to be booked: ", 1, maxSeat);
        b.booked += seat;
        return new Booking(bcode, ccode, seat);
    }
    
    public boolean exist(String bcode, String ccode) {
        for (int i = 0; i < list.size(); i++) {
            Booking b = list.get(i);
            if (b.bcode.equals(bcode) && b.ccode.equals(ccode)) return true;
        }
        return false;
    }
}
