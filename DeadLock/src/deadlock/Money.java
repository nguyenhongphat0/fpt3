/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlock;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phat
 */
public class Money extends Thread{
    Money salary = null;
    int valueSalary = 100;
    
    public synchronized void changeSalary() {
        try {
            Thread.sleep(300);
            valueSalary++;
            System.out.println("Salary: " + valueSalary);
        } catch (InterruptedException ex) {
            Logger.getLogger(Money.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void run() {
        while (true) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Money.class.getName()).log(Level.SEVERE, null, ex);
        }
        salary.changeSalary();}
    }
}
