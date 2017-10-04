/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class HoanVi {
    static int n = 4;
    static int[] a;
    static boolean[] c;

    /**
     * @param args the command line arguments
     */
    
    static void cout() {
        for (int i : a) System.out.print(i + " ");
        System.out.println();
    }

    
    static void hv(int i) {
        for (int j=1; j<=n; j++)
            if (!c[j]) {
                a[i] = j;
                c[j] = !c[j];
                if (i == n-1) cout();
                else hv(i+1);
                c[j] = !c[j];
            }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        n = 3;
        a = new int[n];
        c = new boolean[n+1];
        hv(0);

    }
    
}
    