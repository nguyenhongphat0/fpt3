/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class Heap {
    public static void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }
    
    public static int[] buildHeap(int[] a) {
        int[] h = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            h[i] = a[i];
            int d = i;
            while (d >= 0) {
                if (h[d] > h[(d-1)/2]) {
                    swap(h, d, (d-1)/2);
                    d = (d-1)/2;
                }
                else break;
            }
        }
        return h;
    }
    
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] a = {1,2,7,9,5,4,3,10};
        printArray(a);
        int[] h = buildHeap(a);
        printArray(h);
    }
    
}
