/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemultithread.demo;

/**
 *
 * @author Phat
 */
public class MyThread implements Runnable {

    public MyThread() {
    }
    
    @Override
    public void run() {
        System.out.println("This is child thread!");
    }
    
}
