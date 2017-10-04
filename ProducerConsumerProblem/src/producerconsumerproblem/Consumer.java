/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerproblem;

/**
 *
 * @author Phat
 */
public class Consumer extends Thread {
    Store store;

    public Consumer(Store store) { // create the consumer attached with the given store
        this.store = store;
    }

    @Override
    public void run() { // take product out of store every 0.5 s
        while (true) {
            try {
                Thread.sleep(500);
                int x = store.get();
                if (x > 0) System.out.println("-- Product " + x + " is bought");
                else System.out.println("Consumer is waiting for product");
            } catch (Exception ex) {
                System.out.println("Error happened!");
            }
        }
    }
    
    
    
}
