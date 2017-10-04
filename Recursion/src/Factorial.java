
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    static int factorial(int n) {
        if (n == 1) return 1;
        else return factorial(n-1)*n;
    }
    
    static int iterationFactorial(int n) {
        int s = 1;
        for (int i = 1; i <= n; i++) s *= i;
        return s;
    }
    
    static int stackFactorial(int n) {
        Stack<Integer> s = new Stack<>();
        s.push(n);
        while (n > 1) s.push(s.pop()*--n);
        return s.pop();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        // recursion
        System.out.println(factorial(6));
        
        // iteration
        System.out.println(iterationFactorial(6));
        
        // stack
        System.out.println(stackFactorial(6));
    }
    
}
