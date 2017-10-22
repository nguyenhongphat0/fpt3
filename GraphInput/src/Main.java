
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhongphat0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    static int[] readAnInt(BufferedReader br) {
        int x[] = null;
        int n = 0;
        try {
            String s[] = br.readLine().split(" ");
            x = new int[s.length];
            for (String as : s) {
                x[n] = Integer.parseInt(as);
                n++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }
    
    static int[][] loadMatrix(String filename) {
        int a[][] = null;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            int size = readAnInt(br)[0];
            a = new int[size][size];
            for (int i = 0; i < size; i++) {
                a[i] = readAnInt(br);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a == null) a = new int[0][0];
        return a;
    }
    
    static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    static void dfs(int[][] a, int[] c, int x, int d) {
        c[x] = d;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 0 && a[x][i] > 0) dfs(a, c, i, d);
        }
    }
    
    static int[] countAdjCom(int[][] a) {
        int[] c = new int[a.length];
        int d = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 0) dfs(a, c, i, ++d);
        }
        return c;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int a[][] = loadMatrix("input.txt");
        
        DIJKSTRA dj = new DIJKSTRA(a, 0, 4);
        dj.go();
        Stack<Integer> path = dj.trace();
        System.out.println("Shortest path from "+dj.from+" to "+dj.to+" is: "+dj.f[dj.to].value);
        System.out.print(path.pop());
        while (!path.isEmpty()) {
            System.out.print(" -> " + path.pop());
        }
        System.out.println();
    }
    
}
