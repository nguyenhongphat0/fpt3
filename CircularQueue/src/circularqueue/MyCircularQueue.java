/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularqueue;

/**
 *
 * @author Phat
 */
public class MyCircularQueue {
    int[] list;
    int front, rear, capacity, size;

    public MyCircularQueue(int capacity) {
        this.capacity = capacity;
        list = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public boolean isFull() {
        return size() == capacity;
    }
    
    public int size() {
        return size;
    }
    
    public void enqueue(int e) {
        if (isFull()) throw new RuntimeException("Queue full!");
        else {
            list[(++rear)%capacity] = e;
            size++;
        }
    }
    
    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue empty!");
        else {
            int res = list[front];
            front = (front+1)%capacity;
            size--;
            return res;
        }
    }
    
    public int front() {
        return list[front];
    }
}