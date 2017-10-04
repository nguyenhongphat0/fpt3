/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phat
 */
public class Champion extends Thread{
    public String name;
    public Champion sp;

    public Champion(String name) {
        this.name = name;
    }
    
    public synchronized void attack() {
        System.out.println(name + " is attacking");
    }

    @Override
    public synchronized void run() {
        while (true) this.sp.attack();
    }
}
