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
public class BookingMenu extends Menu {
    BookingList bkl = new BookingList();
    
    public BookingMenu() {
    }

    public BookingMenu(String title) {
        super(title);
    }
    
    @Override
    public void f1() {
        Booking b = bkl.newBooking();
        if (b != null) {
            bkl.list.addFirst(b);
            System.out.println("Action completed!");
        }
    }    
     
    @Override
    public void f2() {
        System.out.printf("%-8s%-8s%-15s%-15s\n", "BCode", "CCode", "Seats Booked", "Available");
        for (int i = 0; i < bkl.list.size(); i++) System.out.println(bkl.list.get(i));
    }
    
    @Override
    public void f3() {
        bkl.list.sort();
        System.out.println("Sorting done!");
    }
}
