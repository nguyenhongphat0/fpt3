/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlock;

/**
 *
 * @author Phat
 */
public class DeadLock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Money husband = new Money();
        Money wife = new Money();
        husband.salary = wife;
        wife.salary = husband;
        husband.start();
        wife.start();
    }
}
