/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salemanagementsystem;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author DuongPTH
 */
public class Menu {

    private Vector<String> m = null;
    private int index;
    private Scanner sc = new Scanner(System.in);

    public int getIndex() {
        return index;
    }

    public Menu() {
        m = new Vector<>();
        index = 0;
    }

    public void addOption(String s) {
        m.add(index++, s);
    }

    private int validOption(int choice) {
        try {
            System.out.print("You choose : ");
            choice = Integer.parseInt(sc.nextLine().trim());
            if (choice < 0 || choice >= index) {
                throw new Exception("Option is not valid");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return choice;
        }
    }

    public int chooseOption() {
        int choice;
        do {
            for (int i = 0; i < index; i++) {
                System.out.println(i + ".   " + m.elementAt(i));
            }
            choice = validOption(-1);
        } while (choice == -1);
        return choice;
    }
}
