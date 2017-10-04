/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class GCD {

    /**
     * @param args the command line arguments
     */
    
    static int gcd(int a, int b) {
        if (a == 0) return b;
        else if (b == 0) return a;
        else return a>b?gcd(a%b, b):gcd(b%a,a);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        
        // recursion
        System.out.println(gcd(18, 33));
    }
    
}
