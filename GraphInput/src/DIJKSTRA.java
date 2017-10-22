
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
public class DIJKSTRA {
    int[][] a;
    Dijnode[] f;
    int from, to, res;
    
    public static final int MAXINT = 999999999;
    
    class Dijnode {
        int which, value, trace;
        boolean fine;

        public Dijnode(int which, int value, int trace, boolean fine) {
            this.which = which;
            this.value = value;
            this.trace = trace;
            this.fine = fine;
        }
        
        
    }
    
    private void printAll() {
        for (Dijnode e : f) {
            System.out.println("->" + e.value);
        }
    }
    
    public DIJKSTRA() {
    }

    public DIJKSTRA(int[][] a, int from, int to) {
        this.a = a;
        this.f = new Dijnode[a.length];
        for (int i = 0; i < a.length; i++) {
            f[i] = new Dijnode(i, MAXINT, -1, false);
        }
        this.from = from;
        this.to = to;
    }
    
    public void go() {
        f[from].value = 0;
        while (!f[to].fine) {
            int t = to;
            for (int i = 0; i < a.length; i++) {
                if (!f[i].fine && f[i].value < f[t].value) {
                    t = i;
                }
            }
            f[t].fine = true;
            for (int i = 0; i < a.length; i++) {
                if (!f[i].fine && a[t][i] != 0 && f[i].value > f[t].value + a[t][i]) {
                    f[i].value = f[t].value + a[t][i];
                    f[i].trace = t;
                }
            }
        }
        res = f[to].value;
    }
    
    public Stack<Integer> trace() {
        Stack<Integer> st = new Stack<>();
        st.push(to);
        while (f[st.peek()].trace != -1) st.push(f[st.peek()].trace);
        return st;
    }
    
}
