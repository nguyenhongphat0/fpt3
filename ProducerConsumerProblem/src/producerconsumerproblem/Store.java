/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerproblem;

import java.util.LinkedList;

/**
 *
 * @author Phat
 */
public class Store {
    LinkedList<Integer> products = new LinkedList<>(); // this will be the queued present the products in the store

    public Store() {
    }
    
    public boolean isEmpty() { // check if the store has any product left
        return products.isEmpty();
    }
    
    public boolean isFull() { // check if the store is full or not
        return products.size() == 50;
    }
    
    public synchronized boolean put(int x) { // put new product to store, return true on success
        if (isFull()) return false;
        products.addLast(x);
        return true;
    }
    
    public synchronized int get() {
        if (isEmpty()) return 0;
        return products.removeFirst();
    }
}
