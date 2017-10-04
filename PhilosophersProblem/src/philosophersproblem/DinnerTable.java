/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philosophersproblem;

/**
 *
 * @author Phat
 */
public class DinnerTable {
    static ChopStick[] sticks = new ChopStick[5]; // the 5 chopsticks
    static Philosopher[] philosophers = new Philosopher[5]; // the 5 philosophers
    
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) sticks[i] = new ChopStick();
        for (int i = 0; i < 5; i++) philosophers[i] = new Philosopher(i, sticks[i], sticks[(i+1)%5]);
        for (int i = 0; i < 5; i++) philosophers[i].start(); // start the dinner
    }
}
