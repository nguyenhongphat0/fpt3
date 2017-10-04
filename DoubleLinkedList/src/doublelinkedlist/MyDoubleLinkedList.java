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
public class MyDoubleLinkedList<T extends Comparable> {
    public Node<T> head, tail;

    public MyDoubleLinkedList() {
        head = tail = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void addFirst(T p){
        Node<T> n = new Node<>(p);
        if (isEmpty()) {
            head = tail =  n;
        } else {
            n.next = head;
            head.pre = n;
            head = n;
        }
    }
    
    public void addLast(T p) {
        Node<T> n = new Node<>(p);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            n.pre = tail;
            tail = n;
        }
    }
    
    public void addPos(int pos, T p){
        if (size() < pos || pos < 0) throw new RuntimeException();
        if (pos == 0) {
            addFirst(p);
            return;
        }
        Node<T> n = new Node<>(p);
        Node<T> q = nodeAt(pos - 1);
        n.next = q.next;
        if (q.next != null) q.next.pre = n;
        n.pre = q;
        q.next = n;
    }
    
    public void addMany(T[] a) {
        for (T i : a) addLast(i);
    }
    
    public void printAll() {
        Node<T> t = head;
        while (t != null) {
            System.out.print(t.info + " ");
            t = t.next;
        }
        System.out.println();
    }
    
    public int size() {
        int d = 0;
        Node<T> t = head;
        while (t != null) {            
            d++;
            t = t.next;
        }
        return d;
    }
    
    private Node<T> nodeAt(int pos) {
        Node<T> t = head;
        for (int i = 0; i < pos; i++) {
            t = t.next;
        }
        return t;
    }
    
    public T Get(int pos) {
        Node<T> t = head;
        for (int i = 0; i < pos; i++) {
            t = t.next;
        }
        return t.info;
    }
    
    public int indexOf(T n) {
        for (int i = 0; i < size(); i++) {
            if (nodeAt(i).info == n) return i;
        }
        return -1;
    }
    
    public void sort() {
        for (int i = 0; i < size(); i++)
            for (int j = i+1; j < size(); j++)
                if (nodeAt(i).info.compareTo(nodeAt(j).info) > 0) {
                    T t = nodeAt(j).info;
                    nodeAt(j).info = nodeAt(i).info;
                    nodeAt(i).info = t;
                }
    }

    public boolean contains(T n) {
        return indexOf(n) != -1;
    }
    
    public String toString() {
        if (isEmpty()) return "[]";
        String s = "[";
        Node<T> t = head;
        while (t.next != null) {
            s+= t.info + ", ";
            t = t.next;
        }
        s += t.info + "]";
        return s;
    }
}
