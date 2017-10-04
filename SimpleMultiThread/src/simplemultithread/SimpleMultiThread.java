/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemultithread;

import simplemultithread.demo.MyThread;

/**
 *
 * @author Phat
 */
public class SimpleMultiThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        System.out.println("Start main");
        MyThread mine = new MyThread();
        Thread t = new Thread(mine);
        t.start();
        t.join();
        System.out.println("End main");
    }
    
}
