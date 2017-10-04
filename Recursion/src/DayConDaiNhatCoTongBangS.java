
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class DayConDaiNhatCoTongBangS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }
        System.out.print("S = ");
        int s = sc.nextInt();
        
        boolean f[] = new boolean[s+1];
        f[0] = true;
        for (int i = 0; i < n; i++) f[a[i]] = true;
        for (int i = 1; i <= s; i++)
            for (int j = 1; j < i; j++)
                if (!f[i] && f[j] && f[i-j]) f[i] = true;
        for (boolean b : f) System.out.println(b);
    }
    
}
