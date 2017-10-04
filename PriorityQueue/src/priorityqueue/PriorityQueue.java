/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

import java.util.ArrayList;

/**
 *
 * @author Phat
 */
public class PriorityQueue {
    ArrayList<Person> list = new ArrayList<>();

    public PriorityQueue() {
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public int size() {
        return list.size();
    }
    
    public void enqueue(String name, int priority) {
        if (isEmpty()) {
            list.add(new Person(name, priority));
        } else {
            int d = 0;
            while (d < size())
                if (list.get(d).priority >= priority) d++;
                else break;
            list.add(d, new Person(name, priority));
        }
    }
    
    public Person dequeue() {
        return list.remove(0);
    }
    
    public Person front() {
        return list.get(0);
    }
}
