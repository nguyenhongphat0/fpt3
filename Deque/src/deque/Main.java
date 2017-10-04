/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;

/**
 *
 * @author Phat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyDeque d = new MyDeque();
        d.pushBack(12);
        d.pushBack("Hello");
        d.pushFront("Hi");
        d.pushFront(-5);
        
        System.out.println(d.popBack());
        System.out.println(d.popBack());
        System.out.println(d.popFront());
        System.out.println(d.popFront());
    }
    
}
