/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularqueue;

import java.util.Scanner;

/**
 *
 * @author Phat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyCircularQueue cq = new MyCircularQueue(10);
        System.out.println("You have a circular queue with 10 number");
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        do {
            try {
                System.out.print("Enter 1 to enqueue new number, 2 to dequeue and 3 to quit: ");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice > 3 || choice < 1) throw new RuntimeException();
                switch (choice) {
                    case 1: 
                        System.out.print("Enter a number: ");
                        try {
                            cq.enqueue(Integer.parseInt(sc.nextLine()));
                        } catch(NumberFormatException ea) {
                            System.out.println("Invalid number");
                        } catch(Exception e) {
                            System.out.println("Queue full! Pop something out to push more");
                        }
                        break;
                    case 2:
                        try {
                            System.out.println("You got " + cq.dequeue());
                        } catch(Exception e) {
                            System.out.println("Queue empty!");
                        }
                        break;
                    case 3: 
                        stop = true;
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Incorrect command!");
            }
        } while (!stop);
    }
    
}
