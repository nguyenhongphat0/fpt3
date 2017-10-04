/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.Scanner;

/**
 *
 * @author Phat
 */
public class Stack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyStack<Integer> st = new MyStack<>();
//        st.push(123);
//        st.push(4);
//        st.push(-9);
//        
//        System.out.println(st.pop());
//        System.out.println(st.pop());
//        System.out.println(st.pop());
        
        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int x;
        while (true) {
            try {
                String s = sc.nextLine();
                x = Integer.parseInt(s);
                break;
            } catch (Exception e) {
                System.out.println("Invalid number! Try again");
                System.out.print("Enter a number: ");
            }
        }
        MyStack<Integer> s = new MyStack<>();
        while (x != 0) {
            s.push(x%2);
            x = x/2;
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
        System.out.println("");
    }
}
