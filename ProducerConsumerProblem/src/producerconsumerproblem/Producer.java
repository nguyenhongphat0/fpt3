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
public class Producer extends Thread{
    Store store;

    public Producer(Store store) { // create the producer attached with the given store
        this.store = store;
    }

    @Override
    public void run() { // add product to store every 0.5 s
        for (int i = 1; true; i++) {
            try {
                Thread.sleep(500);
                if (store.put(i)) System.out.println("++ Product " + i + " is made");
                else System.out.println("Store is full");
            } catch (Exception ex) {
                System.out.println("Error happened!");
            }
        }
    }
    
    
    
}
