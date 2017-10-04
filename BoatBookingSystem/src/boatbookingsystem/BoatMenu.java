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
public class BoatMenu extends Menu {
    BoatList bl = new BoatList();
    
    public BoatMenu() {
    }

    public BoatMenu(String title) {
        super(title);
    }

    @Override
    public void f1() {
        bl.loadFromFile(Reader.readAString("Enter filename: ", ".+"), bl.list.isEmpty()?2:Reader.readANumber("Your list is not empty, enter 1 to insert new data, 2 for overwrite all: ", 1, 2));
    }

    @Override
    public void f2() {
        bl.list.addFirst(bl.newBoat());
        System.out.println("Action completed!");
    }    

    @Override
    public void f3() {
        System.out.printf("%-6s%-15s%-8s%-8s%-15s%-10s%-15s\n", "Code", "Name", "Seat", "Booked", "Depart Place", "Rate", "Available");
        for (int i = 0; i < bl.list.size(); i++) System.out.println(bl.list.get(i));
    }

    @Override
    public void f4() {
        bl.saveToFile(Reader.readAString("Enter filename: ", ".+"));
    }

    @Override
    public void f5() {
        int pos = bl.search(Reader.readAString("Enter code: "));
        if (pos == -1) System.out.println("No boat was found!");
        else {
            System.out.println("Found 1 boat at position " + pos);
            System.out.println(bl.list.get(pos));
        }
    }

    @Override
    public void f6() {
        int pos = bl.search(Reader.readAString("Enter code: "));
        if (pos == -1) System.out.println("Code not found!");
        else {
            bl.list.remove(pos);
            System.out.println("Action completed!");
        }
    }

    @Override
    public void f7() {
        bl.list.sort();
        System.out.println("Sorting done!");
    }

    @Override
    public void f8() {
        int pos = bl.search(Reader.readAString("That boat code: "));
        if (pos == -1) {
            System.out.println("Code not found!");
            return;
        }
        System.out.println("Input new boat information ");
        bl.list.addPos(pos, bl.newBoat());
        System.out.println("Action completed!");
    }

    @Override
    public void f9() {
        int pos = bl.search(Reader.readAString("That boat code: "));
        if (pos == -1) {
            System.out.println("Code not found!");
            return;
        }
        bl.list.remove(pos-1);
        System.out.println("Action completed!");        
    }
    
}
