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
public class MainMenu extends Menu {

    public MainMenu() {
    }

    public MainMenu(String title) {
        super(title);
    }
    
    @Override
    public int getChoice() {
        showOptions();
        int c = Reader.readANumber("Your choice: ", 1, options.size());
        System.out.println();
        return c;
    }

    @Override
    public void f1() {
        Main.bm.run();
    }
    
    @Override
    public void f2() {
        Main.cm.run();
    }

    @Override
    public void f3() {
        Main.bkm.run();
    }
}
