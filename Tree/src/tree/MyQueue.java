/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.LinkedList;

/**
 *
 * @author Phat
 */
public class MyQueue<T> {
    private LinkedList<T> list = new LinkedList<>();

    public MyQueue() {
    }
    
    public void enqueue(T e) {
        list.addLast(e);
    }
    
    public T dequeue() {
        if (list.isEmpty()) throw new RuntimeException();
        return list.removeFirst();
    }
    
    public T front() {
        return list.getFirst();
    }
    
    public int size() {
        return list.size();
    }
    
    public void clear() {
        list.clear();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
