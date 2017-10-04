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
public class CustomerMenu extends Menu {
    CustomerList cl = new CustomerList();

    public CustomerMenu() {
    }

    public CustomerMenu(String title) {
        super(title);
    }

    @Override
    public void f1() {
        cl.loadFromFile(Reader.readAString("Enter filename: ", ".+"), cl.list.isEmpty()?2:Reader.readANumber("Your list is not empty, enter 1 to insert new data, 2 for overwrite all: ", 1, 2));
    }

    @Override
    public void f2() {
        cl.list.addFirst(cl.newCustomer());
        System.out.println("Action completed!");
    }    

    @Override
    public void f3() {
        System.out.printf("%-6s%-15s%-15s\n", "Code", "Name", "Phone");
        for (int i = 0; i < cl.list.size(); i++) System.out.println(cl.list.get(i));
    }

    @Override
    public void f4() {
        cl.saveToFile(Reader.readAString("Enter filename: ", ".+"));
    }

    @Override
    public void f5() {
        int pos = cl.search(Reader.readAString("Enter code: "));
        if (pos == -1) System.out.println("No customer was found!");
        else {
            System.out.println("Found 1 customer at position " + pos);
            System.out.println(cl.list.get(pos));
        }
    }

    @Override
    public void f6() {
        int pos = cl.search(Reader.readAString("Enter code: "));
        if (pos == -1) System.out.println("Code not found!");
        else {
            cl.list.remove(pos);
            System.out.println("Action completed!");
        }
    }
    
}
