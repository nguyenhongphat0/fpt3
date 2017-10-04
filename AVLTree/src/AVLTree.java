
import java.util.ArrayList;

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
public class AVLTree<T extends Comparable> extends MyTree<T> {

    public AVLTree() {
    }

    public AVLTree(Node root) {
        super(root);
    }

    @Override
    public Node<T> add(T x) {
        Node<T> t = super.add(x);
        Node<T> u = getUnbalancedNode(t);
        if (u != null) rotate(u);
        return t;
    }
    
    public void add(T[] x) {
        for (T t : x) {
            add(t);
        }
    }
    
    public Node getParent(Node p, Node root) {
        MyQueue<Node> q = new MyQueue<>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            Node t = q.dequeue();
            if (t.left != null) q.enqueue(t.left);
            if (t.right != null) q.enqueue(t.right);
            if (t.left == p || t.right == p) return t;
        }
        return null;
    }
    
    public int getBalanceBase(Node<T> x) {
        if (x == null) return 0;
        return getHeight(x.right) - getHeight(x.left);
    }
    
    public Node<T> getUnbalancedNode(Node<T> justAdded) {
        Node<T> res = getParent(justAdded, root);
        while (Math.abs(getBalanceBase(res)) <= 1) 
            if (res != root) res = getParent(res, root);
            else return null;
        return res;
    }
    
    public void rotateRight(Node<T> x) {
        Node<T> p = getParent(x, root);
        if (p != null) {
            if (p.left == x) p.left = x.left;
            else if (p.right == x) p.right = x.left;
        } else {
            root = x.left;
        }
        Node<T> t = x.left.right;
        x.left.right = x;
        x.left = t;
        System.out.println("=> rotate node " + x.info + " to the right");
    }
    
    public void rotateLeft(Node<T> x) {
        Node<T> p = getParent(x, root);
        if (p != null) {
            if (p.left == x) p.left = x.right;
            else if (p.right == x) p.right = x.right;
        } else {
            root = x.right;
        }
        Node<T> t = x.right.left;
        x.right.left = x;
        x.right = t;
        System.out.println("=> rotate node " + x.info + " to the left");
    }
    
    public void rotate(Node<T> x) {
        if (getBalanceBase(x) > 1 && getBalanceBase(x.right) > 0) { // phai phai
            rotateLeft(x);
        } else if(getBalanceBase(x) > 1 && getBalanceBase(x.right) < 0) { // phai trai
            rotateRight(x.right);
            rotateLeft(x);
        } else if (getBalanceBase(x) < -1 && getBalanceBase(x.left) < 0) { // trai trai
            rotateRight(x);
        } else if(getBalanceBase(x) < -1 && getBalanceBase(x.left) < 0) { // trai phai
            rotateLeft(x.left);
            rotateRight(x);
        }
    }
}
