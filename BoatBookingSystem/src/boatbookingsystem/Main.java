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
public class Main {
    public static BoatMenu bm;
    public static CustomerMenu cm;
    public static BookingMenu bkm;
    public static MainMenu mainMenu;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create boat menu
        bm = new BoatMenu("BOAT LIST");
        bm.addOption("Load data from file");
        bm.addOption("Add new boat to head");
        bm.addOption("Display all boats");
        bm.addOption("Save boat list to file");
        bm.addOption("Search by boat code");
        bm.addOption("Delete by boat code");
        bm.addOption("Sort by boat code");
        bm.addOption("Add before the node having bcode");
        bm.addOption("Delete the node before the node having bcode");
        bm.addOption("Back");
        
        //create customer menu
        cm = new CustomerMenu("CUSTOMER LIST");
        cm.addOption("Load data from file");
        cm.addOption("Add new customer to head");
        cm.addOption("Display all customers");
        cm.addOption("Save customer list to file");
        cm.addOption("Search by customer code");
        cm.addOption("Delete by customer code");
        cm.addOption("Back");
        
        //create booking menu
        bkm = new BookingMenu("BOOKING LIST");
        bkm.addOption("Input data");
        bkm.addOption("Display data with available seats");
        bkm.addOption("Sort by bcode and ccode");
        bkm.addOption("Back");
        
        //create main menu
        mainMenu = new MainMenu("BOAT BOOKING SYSTEM");
        mainMenu.addOption("Manage Boats");
        mainMenu.addOption("Manage Customers");
        mainMenu.addOption("Manage Bookings");
        mainMenu.addOption("Quit");
        
        //start the program
        mainMenu.run();
        System.out.println("======== GOOD BYE! ========");
    }
}
