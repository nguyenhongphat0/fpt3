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
public class Philosopher extends Thread{
    int position;
    ChopStick leftStick, rightStick;

    public Philosopher(int position, ChopStick leftStick, ChopStick rightStick) {
        this.position = position;
        this.leftStick = leftStick;
        this.rightStick = rightStick;
    }
    
    public void eat() { // take up 2 chopsticks and eat
        leftStick.getUp();
        rightStick.getUp();
        System.out.println("++ The " + position + "(th) philosopher is eating");
    }
    
    public void think() { // drop down 2 chopsticks and think
        leftStick.getDown();
        rightStick.getDown();
        System.out.println("-- The " + position + "(th) philosopher is thinking");
    }

    @Override
    public void run() { // start the philosopher eat and think and eat and think every 1 s
        while (true) {            
            try {
                eat();
                sleep(1000);
                think();
                sleep(1000);
            } catch (Exception e) {
                System.out.println("Error happened!");
            }
        }
    }
    
    
}
