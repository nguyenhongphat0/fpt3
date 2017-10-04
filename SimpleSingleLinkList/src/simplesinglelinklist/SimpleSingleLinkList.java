/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplesinglelinklist;

import java.util.LinkedList;

/**
 *
 * @author Phat
 */
public class SimpleSingleLinkList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyLinkedList list = new MyLinkedList();
        list.addFirst(5);
        list.addLast(4);
        list.addFirst("Hello");
        list.addFirst(7);
        list.addPos(0, "Hi");
        System.out.println("Chữ Hello đang nằm ở vị trí thứ " + list.indexOf("Hello"));
        list.printAll();
        try {
            list.sort();
            System.out.print("Danh sách liên kết sau khi đã được sắp xếp: ");
            list.printAll();
        } catch (Exception e) {
            System.out.println("Danh sách này không thể sắp xếp vì không thể so sánh được");
        }
        
        //Test for string
        MyLinkedList<String> ls = new MyLinkedList<>();
        String[] ss = {"Hello", "Hihi", "Goodbye"};
        ls.addMany(ss);
        ls.sort();
        ls.printAll();
        
        System.out.print("Danh sách liên kết có sẵn của Java: ");
        LinkedList l = new LinkedList();
        l.addFirst(5);
        l.addLast(4);
        l.addFirst(7);
        l.addLast(12);
        l.add(2, -6);
        System.out.println(l);
    }
    
}
