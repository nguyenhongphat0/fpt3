/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boatbookingsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Phat
 */
public class CustomerList {
    public MyLinkedList<Customer> list = new MyLinkedList<>();

    public CustomerList() {
    }
    
    public Customer newCustomer() {
        String code;
        do {
            code = Reader.readAString("Enter code: ", ".+");
            if (search(code) != -1) System.out.println("Code existed. Try another");
        } while (search(code) != -1);
        String name = Reader.readAString("Enter name: ", ".+");
        String phone = Reader.readAString("Enter phone number (3-12 digits): ", "\\d{3,12}");
        return new Customer(code, name, phone);
    }
    
    public int search(String code) {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).ccode.equals(code)) return i;
        return -1;
    }
    
    public void saveToFile(String filename) {
        try {
            PrintWriter pw = new PrintWriter(filename);
            for (int i = 0; i < list.size(); i++) {
                Customer c = list.get(i);
                pw.println(c.ccode+"|"+c.customerName+"|"+c.phone);
            }
            pw.close();
            System.out.println("File saved successfull!");
        } catch (IOException e) {
            System.out.println("Error creating the file! File is being used or you don't have the right permission");
            System.out.println(e);
        }
    }
    
    public void loadFromFile(String filename, int mode) { // insert if mode = 1, overwrite if mode = 2
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            if (mode == 2) list = new MyLinkedList<>();
            int d = 0, success = 0;
            while ((line = br.readLine()) != null) { 
                d++;
                String[] s = line.split(" *\\| *");
                try {
                    if (!s[2].matches("\\d{3,12} *")) throw new NumberFormatException();
                    list.addLast(new Customer(s[0], s[1], s[2].trim()));
                    success++;
                } catch(NumberFormatException e) {
                    System.out.println("Cannot load data from line " + d + " because of invalid number format! ");
                }
            }
            System.out.println(success + " customer(s) loadded to list");
        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }
}
