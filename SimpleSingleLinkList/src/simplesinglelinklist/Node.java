/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplesinglelinklist;

/**
 *
 * @author Phat
 */
public class Node<T extends Comparable> {
    public T info;
    public Node next;

    public Node() {
    }

    public Node(T info) {
        this(info, null);
    }

    public Node(T info, Node next) {
        this.info = info;
        this.next = next;
    }
}
