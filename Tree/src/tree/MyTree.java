/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author Phat
 */
public class MyTree<T extends Comparable> {
    Node<T> root;
    private int height, node1, node2, leaf;
    
    public MyTree() {
    }

    public MyTree(Node root) {
        this.root = root;
    }
    
    public void add(T x) {
        int d = 0;
        if (root == null) {
            root = new Node(x);
            leaf++;
            return;
        }        
        Node t = root, p = null;
        while (t != null) {
            p = t;
            d++;
            if (x.compareTo(t.info) > 0) t = t.right;
            else t = t.left;
        }
        if (p.left == null && p.right == null) node1++;
        else {
            node2++;
            node1--;
            leaf++;
        }
        if (x.compareTo(p.info) > 0) p.right = new Node(x);
        else p.left = new Node(x);
        if (d > height) height = d;
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

    public int height() {
        return height;
    }
    
    public int countLeaf() {
        return leaf;
    }
    
    public int countNode() {
        return node1+node2;
    }
    
    public int count1Node() {
        return node1;
    }
    
    public int count2Node() {
        return node2;
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
    
    public Node search(T val, Node root) {
        if (root.info.equals(val)) return root;
        else if (val.compareTo(root.info) > 0) 
            if (root.right == null) return null; else return search(val, root.right);
        else
            if (root.left == null) return null; else return search(val, root.left);
    }
    
    public Node getParent(Node p) {
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
    
    public boolean isLeft(Node t) {
        Node p = getParent(t);
        return p.left == t;
    }
    
    public void destroy(Node t) {
        Node p = getParent(t);
        if (p.left == t) p.left = null;
        else if (p.right == t) p.right = null;
    }
    
    public void deleteByCopy(T x) {
        Node t = search(x, root);
        if (t.left == null && t.right == null) destroy(t);
        else if (t.left == null && t.right != null)
            if (isLeft(t)) getParent(t).left = t.right;
            else getParent(t).right = t.right;
        else if (t.left != null && t.right == null) 
            if (isLeft(t)) getParent(t).left = t.left;
            else getParent(t).right = t.left;
        else {
            Node p = t.right;
            while (p.left != null) p = p.left;
            t.info = p.info;
            if (isLeft(p)) getParent(p).left = p.right;
            else getParent(p).right = p.right;
        }
    }
    
    public void deleteByMerge(T x) {
        Node t = search(x, root);
        if (t == root) {
            Node p = t.right;
            while (p.left != null) p = p.left;
            p.left = t.left;
            root = t.right;
        }
        else if (t.left == null && t.right == null) destroy(t);
        else if (t.left == null && t.right != null)
            if (isLeft(t)) getParent(t).left = t.right;
            else getParent(t).right = t.right;
        else if (t.left != null && t.right == null) 
            if (isLeft(t)) getParent(t).left = t.left;
            else getParent(t).right = t.left;
        else {
            Node p = t.right;
            while (p.left != null) p = p.left;
            p.left = t.left;
            if (isLeft(t)) getParent(t).left = t.right;
            else getParent(t).right = t.right;
        }
    }
}
