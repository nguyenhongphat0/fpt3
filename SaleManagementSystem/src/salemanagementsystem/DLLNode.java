/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salemanagementsystem;

/**
 *
 * @author DuongPTH
 * @param <E>
 */
public class DLLNode<E extends Comparable> {

    protected E info;
    protected DLLNode prev;
    protected DLLNode next;

    public DLLNode() {
    }

    public DLLNode(E info) {
        this.info = info;
    }

    public DLLNode getPrev() {
        return prev;
    }

    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public E getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return " " + info;
    }
}
