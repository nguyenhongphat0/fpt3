/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;

import java.util.LinkedList;

/**
 *
 * @author Phat
 */
public class MyDeque<T> {
    LinkedList<T> list = new LinkedList<>();

    public MyDeque() {
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public int size() {
        return list.size();
    }
    
    public void pushFront(T e) {
        list.addFirst(e);
    }
    
    public void pushBack(T e) {
        list.addLast(e);
    }
    
    public T popFront() {
        return list.removeFirst();
    }
    
    public T popBack() {
        return list.removeLast();
    }
    
    public T front() {
        return list.getFirst();
    }
    
    public T back() {
        return list.getLast();
    }
}
