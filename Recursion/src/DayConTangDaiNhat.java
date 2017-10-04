
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
public class DayConTangDaiNhat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        int f[] = new int[n];
        int c[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }
        
        for (int i = 0; i < c.length; i++) {
            c[i] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && f[i] < f[j]+1) {
                    f[i] = f[j] + 1;
                    c[i] = j;
                }
            }
        }
        
        int pos = 0;
        for (int i = 1; i < n; i++) {
            if (f[i] > f[pos]) {
                pos = i;
            }
        }
        
        String s = "";
        System.out.print("Result: ");
        while (pos != -1) {
            s = a[pos] + " " + s;
            pos = c[pos];
        }
        System.out.println(s);
    }
    
}
