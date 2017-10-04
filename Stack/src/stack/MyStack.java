/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.ArrayList;

/**
 *
 * @author Phat
 */
public class MyStack<T> {
    private ArrayList<T> s = new ArrayList<>();

    public MyStack() {
    }
    
    public MyStack(int n) {
        s.ensureCapacity(n);
    }
    
    public void clear() {
        s.clear();
    }
    
    public boolean isEmpty() {
        return s.isEmpty();
    }
    
    public void push(T x) {
        s.add(x);
    }
    
    public T peek() {
        return s.get(s.size() - 1);
    }
    
    public T pop() {
        if (isEmpty()) throw new RuntimeException();
        return s.remove(s.size() - 1);
    }
}
