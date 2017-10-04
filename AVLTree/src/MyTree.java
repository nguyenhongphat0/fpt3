
import java.util.ArrayList;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 * @param <T>
 */
public class MyTree<T extends Comparable> {
    Node<T> root;
    
    public MyTree() {
    }

    public MyTree(Node root) {
        this.root = root;
    }
    
    public Node<T> add(T x) {
        int d = 0;
        Node<T> newNode = new Node(x);
        if (root == null) {
            root = newNode;
            return newNode;
        }        
        Node t = root, p = null;
        while (t != null) {
            p = t;
            d++;
            if (x.compareTo(t.info) > 0) t = t.right;
            else t = t.left;
        }
        if (x.compareTo(p.info) > 0) p.right = newNode;
        else p.left = newNode;
        return newNode;
    }
    
    public void preorder(Node p) {
        if (p != null) {
            System.out.print(p.info + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }
    
    public void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.info + " ");
            inorder(p.right);
        }
    }
    
    public void inorder(Node<T> p, ArrayList<T> array) {
        if (p != null) {
            inorder(p.left, array);
            array.add(p.info);
            inorder(p.right, array);
        }
    }
    
    public ArrayList<T> toArray() {
        ArrayList<T> a = new ArrayList<>();
        inorder(root, a);
        return a;
    }
    
    public void postorder(Node p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.info + " ");
        }
    }
    
    private int max(int a, int b) {
        return a>b?a:b;
    }
    
    public void bfs(Node p) {
        MyQueue<Node> q = new MyQueue<>();
        q.enqueue(p);
        while (!q.isEmpty()) {          
            if (q.front().left != null) q.enqueue(q.front().left);
            if (q.front().right != null) q.enqueue(q.front().right);
            System.out.print(q.dequeue().info + " ");
        }
    }
    
    public int getHeight(Node<T> x) {
        if (x == null) return -1;
        else if (x.left == null && x.right == null) return 0;
        else return Math.max(getHeight(x.left) + 1, getHeight(x.right) + 1);
    }
    
    public Node search(T val, Node root) {
        if (root.info.equals(val)) return root;
        else if (val.compareTo(root.info) > 0) 
            if (root.right == null) return null; else return search(val, root.right);
        else
            if (root.left == null) return null; else return search(val, root.left);
    }
    
    public void simpleBalance(ArrayList<T> a, int from, int to) {
        int x = (from + to)/2;
        add(a.get(x));
        if (x > from) simpleBalance(a, from, x-1);
        if (x < to) simpleBalance(a, x+1, to);
    }
    
    public void toBalancedTree() {
        ArrayList a = this.toArray();
        this.root = null;
        simpleBalance(a, 0, a.size()-1);
    }
}
