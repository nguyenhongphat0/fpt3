/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philosophersproblem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phat
 */
public class ChopStick {
    boolean ready; // state of the chopstick

    public ChopStick() {
        ready = true;
    }
    
    public synchronized void getUp() {
        if (!ready) {            
            try {
                System.out.println("A philosopher is waiting for chopstick");
                wait();
            } catch (Exception ex) {
                System.out.println("Error happened!");
            }
        }
        ready = false;
    }
    
    public synchronized void getDown() {
        ready = true;
        notify();
    }
}
