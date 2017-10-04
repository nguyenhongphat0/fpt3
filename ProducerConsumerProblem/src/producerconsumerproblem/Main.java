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
public class Main {
    public static void main(String[] args) {
        Store s = new Store(); //the store where products are put and get
        Producer p = new Producer(s); //the producer
        Consumer c = new Consumer(s); //the consumer
        p.start();
        c.start();
    }
}
