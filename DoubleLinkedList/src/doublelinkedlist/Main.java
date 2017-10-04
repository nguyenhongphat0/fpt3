/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublelinkedlist;

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
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        list.addFirst(9);
        list.addLast(-6);
        list.addFirst("Hello");
        list.addPos(1, "After hello");
        System.out.println(list);
    }
    
}
