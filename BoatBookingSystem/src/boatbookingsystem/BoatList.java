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
public class BoatList {
    public MyLinkedList<Boat> list = new MyLinkedList<>();

    public BoatList() {
    }
    
    public Boat newBoat() {
        String code;
        do {
            code = Reader.readAString("Enter code: ", ".+");
            if (search(code) != -1) System.out.println("Code existed. Try another");
        } while (search(code) != -1);
        String name = Reader.readAString("Enter name: ", ".+");
        int seat = Reader.readANumber("Enter seat: ", 1);
        int booked = Reader.readANumber("Enter booked seat: ", 0, seat);
        String departPlace = Reader.readAString("Enter depart place: ");
        Double rate = Reader.readARealNumber("Enter rate: ", 0, 100000000);
        return new Boat(code, name, departPlace, seat, booked, rate);
    }
    
    public int search(String code) {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).bcode.equals(code)) return i;
        return -1;
    }
    
    public void saveToFile(String filename) {
        try {
            PrintWriter pw = new PrintWriter(filename);
            for (int i = 0; i < list.size(); i++) {
                Boat b = list.get(i);
                pw.println(b.bcode+"|"+b.boatName+"|"+b.seat+"|"+b.booked+"|"+b.departPlace+"|"+b.rate);
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
                    list.addLast(new Boat(s[0], s[1], s[4], Integer.parseInt(s[2]), Integer.parseInt(s[3]), Double.parseDouble(s[5])));
                    success++;
                } catch(NumberFormatException e) {
                    System.out.println("Cannot load data from line " + d + " because of invalid number format! ");
                }
            }
            System.out.println(success + " boat(s) loadded to list");
        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }
}
