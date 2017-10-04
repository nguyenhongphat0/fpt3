/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boatbookingsystem;

import java.util.ArrayList;

/**
 *
 * @author Phat
 */
public class Menu {
    ArrayList<String> options = new ArrayList<>();
    String title;

    public Menu() {
    }
    
    public Menu(String title) {
        this.title = title;
    }
    
    public void addOption(String s) {
        options.add(s);
    }
    
    public void showOptions() {
        if (!title.equals("")) System.out.println("======== " + title + " ========");
        for (int i = 0; i < options.size(); i++) System.out.println(i+1 + ". " + options.get(i));
    }
    
    public int getChoice() {
        showOptions();
        int c = Reader.readANumber("Your choice: ", 1, options.size());
        System.out.println();
        System.out.println("-------- " + options.get(c-1) + " --------");
        return c;
    }
    
    public void f1() {}
    public void f2() {}
    public void f3() {}
    public void f4() {}
    public void f5() {}
    public void f6() {}
    public void f7() {}
    public void f8() {}
    public void f9() {}
    
    public void run() {
        int choice;
        do {
            choice = getChoice();
            switch (choice) {
                case 1:
                    f1();
                    break;
                case 2:
                    f2();
                    break;
                case 3:
                    f3();
                    break;
                case 4:
                    f4();
                    break;
                case 5:
                    f5();
                    break;
                case 6:
                    f6();
                    break;
                case 7:
                    f7();
                    break;
                case 8:
                    f8();
                    break;
                case 9:
                    f9();
                    break;
            }
            System.out.println();
        } while (choice != options.size());
    }
}