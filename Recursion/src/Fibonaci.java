/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class Fibonaci {

    /**
     * @param args the command line arguments
     */
    
    static int fibonaci(int n) {
        if (n<2) return 1;
        else return fibonaci(n-1) + fibonaci(n-2);
    }
    
    static int iterationFibonaci(int n) {
        int[] a = new int[100];
        a[0] = a[1] = 1;
        for (int i = 2; i <= n; i++) a[i] = a[i-1] + a[i-2];
        return a[n];        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        // recursion
        for (int i = 0; i < 10; i++) System.out.print(fibonaci(i) + " ");
        System.out.println();
        // iteration
        for (int i = 0; i < 10; i++) System.out.print(iterationFibonaci(i) + " ");
    }
    
}
