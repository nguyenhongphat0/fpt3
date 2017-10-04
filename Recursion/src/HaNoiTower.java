/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class HaNoiTower {
    
        /**
         * @param args the command line arguments
         */
        
        static void move(int n, int from, int to, int by) {
            if (n == 1) {
                System.out.println("Move disc 1 from tower " + from + " to tower " + to);         
            } else {
                move(n-1, from, by, to);
                System.out.println("Move disc " + n + " from tower " + from + " to tower " + to);
                move(n-1, by, to, from);
            }
        }
        
        public static void main(String[] args) {
            // TODO code application logic here
            move(5, 1, 3, 2);
        }
        
    }
    