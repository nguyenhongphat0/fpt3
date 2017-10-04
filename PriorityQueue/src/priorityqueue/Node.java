/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

/**
 *
 * @author Phat
 */
public class Node {
    Person info;
    Node next;

    public Node() {
    }

    public Node(Person info) {
        this.info = info;
    }

    public Node(Person info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Person getInfo() {
        return info;
    }

    public void setInfo(Person info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}
